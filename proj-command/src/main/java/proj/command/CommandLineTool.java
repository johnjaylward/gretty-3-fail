package proj.command;

import proj.model.Person;
import proj.core.PersonDao;

public final class CommandLineTool {
	public static void main(final String[] args){
		PersonDao dao = new PersonDao();
		Person p = dao.get(Long.valueOf(1));
		if(p!=null)
			System.out.println(p.getName());
		else
			System.out.println("Unable to find the requested person");
	}
}
