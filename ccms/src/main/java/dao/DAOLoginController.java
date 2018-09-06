package dao;

import connectors.Connector;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import containers.Model;



public class DAOLoginController {
    private String login;
    private String password;
    private Connector connector;
    private Element elementPerson;
    private NodeList nodePersonList;

    public DAOLoginController(){
        this.connector = new Connector();
    }

    public void setLogin(String login){
        this.login = login;
    }


    public void setPassword(String password){
        this.password = password;
    }


    public Model createModel(){
        if(connector.loadPerson(login)!= null){
            elementPerson = connector.loadPerson(login);
            String documentElement = elementPerson.getLocalName();
            System.out.println(documentElement);
          //  nodePersonList = elementPerson.getElementsByTagName()
        }
        return null;
    }


    public Boolean checkIfExist(){
        return connector.loadPerson(login)!= null;
    }


}
