

const subsectionService = () => {
	
	const upsertSubsection = async (form) => {
		
		const formData = new FormData(form);
	    
		const subsectionForm = {
			subsection_id : Math.floor(Math.random() * 100) + 1,
			section_id: 1,
			description: formData.get("description"),
			facilitator: formData.get("facilitator"),
			details: formData.get("details"),
			target_day: formData.get("target_day"),
			target_sprint: formData.get("target_sprint")
			
		}
		
		const requestData = JSON.stringify({ query : ` mutation {
												  upsertSubsection( form : {
													  subsection_id: "${subsectionForm.subsection_id}",
													  section_id: "${subsectionForm.section_id}",
													  description: "${subsectionForm.description}",
													  facilitator: "${subsectionForm.facilitator}",
													  details: "${subsectionForm.details}",
													  target_day: "${subsectionForm.target_day}",
													  target_sprint: "${subsectionForm.target_sprint}",
												  }) 
												  {
												    subsection_id
												    section_id
												    description
												    facilitator
												    details
												    target_day
												    target_sprint
											  	  }
											}`});
		
		return await $.post( { url : '/graphql', data: requestData, contentType: 'application/json' });
		
	}
	
	const deleteSubsection = async (subsection_id) => {
		return await $.post( 
				{ 	url : '/graphql', 
					data : JSON.stringify({ query: `mutation { deleteSubsection(subsection_id : ${subsection_id}) }`}),
					contentType: 'application/json'
				});
		
		
	}
	
	return {
		upsert : upsertSubsection,
		delete: deleteSubsection
	}
	
}