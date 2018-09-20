package controllers;

import dao.DAOEmployer;
import containers.Model;
import views.View;
import dao.DAOLists;

import java.util.ArrayList;
import java.util.List;

public class AdministratorController extends Controller {

    View view;
    DAOLists daoLists;
    DAOEmployer daoEmployer;
    Model newModel;

    public AdministratorController(Model model, View view) {
        setMyModel(model);
        setloggedIn(true);
        this.view = view;
        this.daoLists = new DAOLists();
        this.daoEmployer = new DAOEmployer();

    }


    public void run() {

        int inputInt = 0;
        boolean goodInput = false;
        List<String> menuOptions = new ArrayList<String>();
                menuOptions.add("List all students");
                menuOptions.add("List all mentors");
                menuOptions.add("Add mentor");
                menuOptions.add("Remove mentor");
                menuOptions.add("Edit mentor");
                menuOptions.add("Logout");


        while(getLoggedIn()) {
            View.printList(menuOptions);

            while(goodInput == false) {
                int FIRST_INPUT = 0;
                int LAST_INPUT = 7;
                try{
                    inputInt = view.takeIntInput("What would you like to do? ");
                }catch(NumberFormatException e){
                    System.out.println("Wrong input!");
                }

                if(inputInt > FIRST_INPUT && inputInt < LAST_INPUT) {
                    goodInput = true;
                } else {
                    view.showMessage("Only numbers from 1 to 6!");
                }
            }
            goodInput = false;
            switch(inputInt){
                case 1:
                    View.printList(daoLists.getAllStudents());
                    break;
                case 2:
                    View.printList(daoLists.getAllMentors());
                    break;
                case 3:
                    addMentor();
                    break;
                case 4:
                    removeMentor();
                    break;
                case 5:
                    editMentor();
                    break;
                case 6:
                    setloggedIn(false);
                    break;
            }

        }
    }

    private void addMentor() {
        String tempName = view.takeStringInput("Name ");
        String tempSurname = view.takeStringInput("Surname ");
        String accountType = "mentor";
        String tempPassword = view.takeStringInput("Password");
        String tempLogin = view.takeStringInput("Login");
        newModel = new Model(tempName, tempSurname, accountType, tempPassword, tempLogin);
        daoEmployer.add(newModel);
    }

    private void removeMentor() {
        View.printList(daoLists.getAllMentors());
        String tempLogin = view.takeStringInput("Login ");
        daoEmployer.delete(tempLogin);
    }

    private void editMentor() {
        View.printList(daoLists.getAllMentors());
        String tempLogin = view.takeStringInput("Login ");
        daoEmployer.delete(tempLogin);
        addMentor();
    }
}
