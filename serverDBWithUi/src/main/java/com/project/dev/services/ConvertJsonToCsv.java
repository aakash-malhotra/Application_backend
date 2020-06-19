package com.project.dev.services;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.dataformat.csv.CsvSchema.Builder;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

public final class ConvertJsonToCsv {
	private ConvertJsonToCsv() {
		
	}
	
	 public static void JsonToCsv(File jsonFile, File csvFile) throws IOException {
	        JsonNode jsonTree = new ObjectMapper().readTree(jsonFile);
	        String s=new String();
	        
	        Builder csvSchemaBuilder = CsvSchema.builder();
	        JsonNode firstObject = jsonTree.elements().next();
	        System.out.println(firstObject);
	        firstObject.fields().forEachRemaining(fieldName -> {
	        	System.out.println(fieldName.getValue().isContainerNode());
	        	if(!fieldName.getValue().isContainerNode()) {
	        		csvSchemaBuilder.addColumn(fieldName.getKey());
	        		System.out.println(fieldName);
	        		}
	        	else {
	        		if(fieldName.getValue().isArray()) {
	        			JsonNode jsonTreeInternal= new ObjectMapper().valueToTree(fieldName.getValue());
	        			System.out.println(jsonTreeInternal);
	        			JsonNode object=jsonTreeInternal.iterator().next();
	        			System.out.println(object);
	        		}
	        		else {
	        			JsonNode jsonTreeInternal= new ObjectMapper().valueToTree(fieldName.getValue());
	        			System.out.println(jsonTreeInternal);
	        			jsonTreeInternal.fields().forEachRemaining(fieldNameInternal -> {
	        				csvSchemaBuilder.addColumn(fieldName.getKey()+"/"+fieldNameInternal.getKey());
	        				System.out.println(fieldName.getKey()+"/"+fieldNameInternal.getKey());
	        			});
	        		}
	        		
	        		
	        		
	        			/*object.fields().forEachRemaining(fieldNameInternal -> {
	    	        	System.out.println(fieldNameInternal.getValue().isContainerNode());
	    	        	if(!fieldNameInternal.getValue().isContainerNode()) {
	    	        		csvSchemaBuilder.addColumn(fieldNameInternal.getKey());
	    	        		System.out.println(fieldNameInternal);
	    	        		}
	    	        	else {
	    	        		System.out.println("inside internal else");
	    	        	}
	        		});
	        		*/
	        	}
	        });
	       
	        /*
	        firstObject.fields().forEachRemaining(fieldName -> {
	        	if(fieldName.) {
	        		csvSchemaBuilder.addColumn(fieldName.toString());
	        		System.out.println(fieldName);
	        		}
	        	else {
	        		
	        	}
	        });
	        */
	        CsvSchema csvSchema = csvSchemaBuilder
	            .build()
	            .withHeader();
	        
	        CsvMapper csvMapper = new CsvMapper();
	        csvMapper.writerFor(JsonNode.class)
	            .with(csvSchema)
	            .writeValue(csvFile, jsonTree);
	    }
	 
	 public static void recurssion() {
		 
	 }
	 
	 public static void givenJsonInput_thenWriteCsv() throws JsonParseException, JsonMappingException, IOException {
	        ConvertJsonToCsv.JsonToCsv(new File("src/main/resources/static/JsonHolder.json"),
	            new File("src/main/resources/static/CsvHolder.csv"));
	 }
	 
	 public static void ReadJsonOutput( List<?> findAll ) throws JsonParseException, JsonMappingException, IOException {
		 ObjectMapper mapper=new ObjectMapper();
			try {
				mapper.writeValue(new File("C:\\Users\\malho\\OneDrive\\Documents\\GitHub\\Application_backend\\"
		   		+ "serverDBWithUi\\src\\main\\resources\\static\\JsonHolder.json"), findAll);
				
				ConvertJsonToCsv.givenJsonInput_thenWriteCsv();
		   
			} 
			catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	 }
}