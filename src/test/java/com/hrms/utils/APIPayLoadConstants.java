package com.hrms.utils;

import org.json.JSONObject;

public class APIPayLoadConstants {
	

		public static String createEmployeeBody() {
			String createEmployeeBody = "{\n"
					+ "    \"emp_firstname\": \"Masha\",\n"
					+ "    \"emp_lastname\": \"Medved\",\n"
					+ "    \"emp_middle_name\": \"And\",\n"
					+ "    \"emp_gender\": \"F\",\n"
					+ "    \"emp_birthday\": \"2016-09-21\",\n"
					+ "    \"emp_status\": \"Employee\",\n"
					+ "    \"emp_job_title\": \"Cloud Architect\"\n"
					+ "\n"
					+ "}";
			return createEmployeeBody;
		}

		public static String createEmployeePayload() {
			JSONObject obj = new JSONObject();
			obj.put("emp_firstname", "Masha");
			obj.put("emp_lastname", "Medved");
			obj.put("emp_middle_name", "And");
			obj.put("emp_gender", "F");
			obj.put("emp_birthday", "2016-09-21");
			obj.put("emp_status", "Employee");
			obj.put("emp_job_title", "Cloud Architect");

			return obj.toString();
		}

		public static String createEmployeePayloadMoreDynamic(String firstName, String lastName, String middleName,
				String gender, String dob, String employeeStatus, String employeeJobTitle) {
			JSONObject obj = new JSONObject();
			obj.put("emp_firstname", firstName);
			obj.put("emp_lastname", lastName);
			obj.put("emp_middle_name", middleName);
			obj.put("emp_gender", gender);
			obj.put("emp_birthday", dob);
			obj.put("emp_status", employeeStatus);
			obj.put("emp_job_title", employeeJobTitle);

			return obj.toString();
		}

	}


