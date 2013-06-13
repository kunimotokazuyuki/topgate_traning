package tgseminar.controller;

import java.util.List;

import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.datastore.Datastore;
import org.slim3.repackaged.org.json.JSONObject;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Query.SortDirection;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserServiceFactory;

public class ListController extends Controller {

	@Override
	protected Navigation run() throws Exception {
		// TODO Auto-generated method stub
		
		User user = UserServiceFactory.getUserService().getCurrentUser();
		String createdBy = user.getEmail();

		List<Entity> asList = Datastore.query("ToDo")
		.filter("createdBy", FilterOperator.EQUAL, createdBy)
		.sort("createdAt", SortDirection.DESCENDING)
		.asList();
		
		String kuni = JSONObject.valueToString(asList);
		response.getWriter().println(kuni);
		
				
		return null;
	}

}
