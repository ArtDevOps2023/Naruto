-- drop pass_fail_flag from flow_section
ALTER TABLE `flow_section` DROP COLUMN `pass_fail_flag`;

-- add pass_fail_flag to employee_flow instead
ALTER TABLE `employee_flow` ADD COLUMN `pass_fail_flag` varchar(1) DEFAULT 'U' AFTER `status`;