/*******************************************************************************
 * Copyright 2017 Observational Health Data Sciences and Informatics
 * 
 * This file is part of WhiteRabbit
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package org.ohdsi.databases;

import com.google.api.services.bigquery.Bigquery;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryOptions;

public class BQConnector {


	public static void main(String[] args) {}

		public static BigQuery connect (String server, String domain, String user, String password, DbType dbType){
			//field mappings:
			//server = BigQuery API string. Example:
			//domain = dataset (overide to avoid changing signature on connection)
			//user = Billing Project
			//password = location of JSON service account file.
			if (dbType.equals(DbType.BIGQUERY))
			{
				return BQConnector.connectToBigQuery(user, domain, password);
			}
			else {
				throw new RuntimeException("Calling BigQuery connection for a database type that is not BigQuery.");}
		}

		public static BigQuery connectToBigQuery(String billing_project, String dataset, String JSON_key_location)
		{
			BigQuery bq = null;
			//if the JSON field wasn't populated - go with the default.
			if   (
					   (JSON_key_location == null)
					|| (JSON_key_location.equals("<key file missing>"))
					|| (JSON_key_location.trim().equals(""))
					|| (JSON_key_location.isEmpty())
				 )
			{
				bq = BigQueryOptions.getDefaultInstance().getService();
			}
            //Otherwsie go with this version to pick up the JSON key.

//			GoogleCredentials credentials;
//			File credentialsPath = new File("service_account.json");  // TODO: update to your key path.
//			try (FileInputStream serviceAccountStream = new FileInputStream(credentialsPath)) {
//				credentials = ServiceAccountCredentials.fromStream(serviceAccountStream);
//			}
//
//			// Instantiate a client.
//			BigQuery bigquery = BigQueryOptions.newBuilder().setCredentials(credentials).build().getService();
//
			return bq;


		}
	}