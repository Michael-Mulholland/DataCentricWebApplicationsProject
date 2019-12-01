package manageHeadOffice;

import java.util.ArrayList;
import org.bson.Document;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import manageProducts.Products;

public class StoreHeadOfficeMongo {

	public static void main(String[] args) {


		// new mongo client
		MongoClient mongoClient = new MongoClient();

		// get database method - with DB name
		MongoDatabase database = mongoClient.getDatabase("storeHeadOffice");

		// Collection Lab8
		MongoCollection<Document> collection = database.getCollection("storeHeadOffice");

		ArrayList<StoreHeadOffice> headOfficeList = new ArrayList<StoreHeadOffice>();
		Gson gson = new Gson();

		FindIterable<Document> headOffices = collection.find();

		for (Document d : headOffices) {
			// convert from JSON to GSON
			StoreHeadOffice headOffice = gson.fromJson(d.toJson(), StoreHeadOffice.class);
			headOfficeList.add(headOffice);
		}

		for(StoreHeadOffice x : headOfficeList) {
			System.out.println(x);
		}
	}
}
