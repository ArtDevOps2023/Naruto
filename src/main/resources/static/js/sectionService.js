

const sectionService = () => {
	
	const upsertSection = async (form) => {
		
		const formData = new FormData(form);
	    
		const sectionForm = {
			section_id : Math.floor(Math.random() * 100) + 1,
			name: formData.get("name"),
			color: formData.get("color")
		}
		
		const requestData = JSON.stringify({ query : ` mutation {
												  upsertSection( form : {
													  section_id: "${sectionForm.section_id}",
													  name: "${sectionForm.name}",
													  color: "${sectionForm.color}"
												  }) 
												  {
												    section_id
												    name
												    color
											  	  }
											}`});
		
		return await $.post( { url : '/graphql', data: requestData, contentType: 'application/json' });
		
	}
	
	const deleteSection = async (section_id) => {
		return await $.post( 
				{ 	url : '/graphql', 
					data : JSON.stringify({ query: `mutation { deleteSection(section_id : ${section_id}) }`}),
					contentType: 'application/json'
				});
		
		
	}
	
	return {
		upsert : upsertSection,
		delete: deleteSection
	}
	
}