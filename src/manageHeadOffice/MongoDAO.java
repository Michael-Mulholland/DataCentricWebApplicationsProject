package manageHeadOffice;

import java.util.ArrayList;
import javax.sql.DataSource;
import org.bson.Document;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDAO {
	
	String mongoDB = "storeHeadOfficeDB";
	String mongoCollection = "storeHeadOffice";
	
	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> collection;
	
	DataSource mysqlDS;
	
	public MongoDAO() throws Exception {
		mongoClient = new MongoClient();
		database = mongoClient.getDatabase(mongoDB);
		collection = database.getCollection(mongoCollection);
	}
	
	public ArrayList<StoreHeadOffice> loadOfficeDetails() throws Exception {
		ArrayList<StoreHeadOffice> headOfficeList = new ArrayList<StoreHeadOffice>();
		FindIterable<Document> headOffices = collection.find();
	
		for (Document d : headOffices) {
			StoreHeadOffice office = new StoreHeadOffice();
			
			office.setId((int)(d.get("_id")));
			office.setLocation((String)(d.get("location")));

			headOfficeList.add(office);
		}
		
		return headOfficeList;
	}
	
	// Adds a new head office
	public void addHeadOffice(StoreHeadOffice office) throws Exception {
		
		Document d = new Document();
		d.append("_id", office.getId());	
		d.append("location", office.getLocation());

		collection.insertOne(d);
		
	}

/*	public boolean checkHeadOfficeID(int id) {
		
		boolean result = false;
		
		// new mongo client
		MongoClient mongoClient = new MongoClient();

		// get database method - with DB name
		MongoDatabase database = mongoClient.getDatabase("storeHeadOfficeDB");

		// Collection Lab8
		MongoCollection<Document> headOfficeCollection = database.getCollection("storeHeadOffice");
		
		// query to find all head offices with an ID
		BasicDBObject query = new BasicDBObject();
		query.put("_id", new BasicDBObject("$exists", true));

		//Get documents from collection 
		FindIterable<Document> offices = headOfficeCollection.find(query);
		
		//Iterate through the documents
		for (Document d : offices) {			
			int mongoID = (int) d.get("_id");
			System.out.println(mongoID);
			if(mongoID == id) {
				result = true;
			}
			else {
				result = false;
			}
		}
		
		mongoClient.close();	
		return result;
	}
*/
}