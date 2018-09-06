package DAO;

import connectors.Connector;
import containers.Assignment;
import containers.Model;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.HashMap;
import java.util.Map;

public class DAOEmployer implements DAOSingleObject {

    private Element element;
    private Connector connector;
    private String tempName;
    private String tempSurname;
    private String accessLevel = "mentor";
    private String tempPassword;
    private String tempLogin;

    public DAOEmployer() {
        this.connector = new Connector();
    }

    public Model get(String login) {
        element = connector.loadPerson(login);
        tempLogin = element.getAttribute("login");
        accessLevel =
        tempName = element.getElementsByTagName("name").item(0).getTextContent();
        tempSurname = element.getElementsByTagName("surname").item(0).getTextContent();
        tempPassword = element.getElementsByTagName("password").item(0).getTextContent();

        return new Model(tempName, tempSurname, accessLevel, tempPassword, tempLogin);
    }

    public void add(Model model) {
        connector.addPersonToXML(model);
    }

    public void delete(String login) {

    }
}
