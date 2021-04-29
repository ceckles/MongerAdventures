/*
  IDE: IntelliJ IDEA
  File Name: Main
  Created by: Chad Eckles.
  Date: 7/12/2017
  INFO:
 */
package MongerAdventures;

import Item.Weapons.Axe.Axe;
import Item.Weapons.Axe.BoneCrusher;
import Item.Weapons.Weapon;
import Logging.*;
import PlayerClasses.PlayerClass;
import Validation.InputValidation;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import static java.text.MessageFormat.format;


public class Main {

    //Global Variables.

    // 0 = User Name, 1 = Role, 2 = Class, 3 = Lvl.
    private String[] _userData = new String[4];

    private InputValidation _isValid = new InputValidation();
    private List<PlayerClass> _playerChar = new ArrayList<>();
    private List<Weapon> _weaponList = new ArrayList<>();

    //that Main Menu Loop.
    private boolean _isRunning = true;

    public static void main(String[] args) throws UnknownHostException{

        //Instantiate Main Method
        Main myMain = new Main();

        //Loggin Info
        Logger.setLogLevel(10);
        Logger.setLogLevel(Logger.LOG_LEVEL_DEBUG);
        // Processing for Passing in Perams..
        for (String arg : args) {
            if (arg.equalsIgnoreCase("-noColors")) {
                Logger.setUseColors(false);
            }
        }

        //Create Weapons
        if(myMain._weaponList.isEmpty()) {
            myMain.CreateWeapons();
        }

        //Main Menu Loop
        do{
            myMain.MainMenu();
        }while (myMain._isRunning);
        //myMain.StartingPoint();

    }

    private void MainMenu(){
       //Main Menu

        String userInput;

        Logger.endPrint();
        Logger.print("Main Menu:", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("1) Create Character.", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("2) Edit Character.", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("3) Equip Weapon.", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("4) Display Char Stats.", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("5) Battle.", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();
        Logger.print("6) Exit", Logger.BOLD,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();

        userInput = _isValid.strValid("Select Menu Option");
        switch (userInput.toUpperCase()){
            case "1":
            case "CREATE":
            case "CREATE CHARACTER":{
                Logger.print("Create Character:", Logger.FAINT,Logger.BLUE,Logger.WHITE);
                Logger.endPrint();
                CreateChar();
                Logger.endPrint();
                break;
            }
            case "2":
            case "EDIT":
            {
                //Char Edit
                Logger.print("Edit Character:", Logger.FAINT,Logger.BLUE,Logger.WHITE);
                Logger.endPrint();
                break;
            }
            case "3":
            case "WEAPON":
            case "EQUIP WEAPON":
            {
                Logger.print("Weapon Equip:", Logger.FAINT,Logger.BLUE,Logger.WHITE);
                Logger.endPrint();
                EquipWeapon();
            }
            case "4":
            case "DISPLAY":
            case "STATS":
            {
                Logger.print("Display Character Stats:", Logger.FAINT,Logger.BLUE,Logger.WHITE);
                Logger.endPrint();
                DisplayStats();
                break;
            }
            case "5":
            case "BATTLE":
            case "FIGHT":
            {
                Logger.print("Fight:", Logger.FAINT,Logger.BLUE,Logger.WHITE);
                Logger.endPrint();
                Battle();
                break;
            }
            case "7":
            case "EXIT": {
                Logger.print("EXITING PROGRAM. ", Logger.FAINT,Logger.BLUE,Logger.YELLOW);
                Logger.endPrint();
                _isRunning = false;
                break;
            }
            default:
                _isRunning = false;
                break;
        }
    }

    private void CreateChar(){
        //Create a Char
        //Char class needs more status and better checks and assignments.
        _userData[0]  = _isValid.strValid("Please Enter User Name: ");
        System.out.println(format("Hello, {0}",_userData[0]));

        _userData[1]  = _isValid.strValid("Please Enter A Role: ");
        System.out.println(format("{0} role set to {1}",_userData[0], _userData[1]));

        _userData[2] = _isValid.strValid("Please set a Class");
        System.out.println(format("{0} class set to {1}",_userData[0],_userData[2]));

        _userData[3] = "1"; //Set to Level 1
        System.out.println(format("Name : {0} Role : {1} Class : {2} Level : {3}",_userData[0],_userData[1],_userData[2],_userData[3]));

        _playerChar.add(new PlayerClass(_userData[0],_userData[1],_userData[2],Integer.parseInt(_userData[3])));

        Logger.print(_playerChar.get(0).getInfo(), Logger.BLINK,Logger.GREEN,Logger.WHITE);
        Logger.endPrint();

    }

    private void CreateWeapons(){
        //Add more weapons and stats.
        //_weaponList.add(new Axe("Bone Crusher","Axe","Bone Crusher, The crusher it's victims in a cleaving blow",22,2,0,100));

        //Add Weapon From Class
        _weaponList.add(new BoneCrusher());
        System.out.printf(_weaponList.get(0).toString() +" Created");

        //Create weapon from super and add
        _weaponList.add(new Axe("Shadowmorne","Axe","Axe that rules them all captures the souls of all it has slain.",52,2,0,100));
        System.out.printf(_weaponList.get(1).toString() +" Created");
    }

    private void EquipWeapon(){
        //Equip a Weapon
        //Needs checks and confirmation.
        String userInput;

        int i = 0;
        for (Weapon w:_weaponList) {
            Logger.print( i+1 +")"+ w.getName(), Logger.BOLD,Logger.RED,Logger.WHITE);
            Logger.endPrint();
            i++;
        }
        userInput = _isValid.strValid("Select a Weapon:");
        _playerChar.get(0).setWeapon(_weaponList.get(Integer.parseInt(userInput)-1));
    }

    private void DisplayStats(){
        //Stats display needs more work.
        //Display of Char Stats
        System.out.println(format("Name : {0}, Role : {1}, Class : {2}, Level : {3}, Weapon : {4}."
                ,_playerChar.get(0).getName(),_playerChar.get(0).getRole(),_playerChar.get(0).getPlayerClass(),
                _playerChar.get(0).getLevel(),_playerChar.get(0).getWeapon().getName()));
    }

    private void Battle(){

        //Battle Method.
        Logger.w("Player Health is : ", _playerChar.get(0).getHealth(),".");
        Logger.endPrint();
        _playerChar.get(0).decreaseHealth(10);
        Logger.w("Player Attacked Health is now : ", _playerChar.get(0).getHealth());
        Logger.endPrint();
        Logger.w("Player Healed for : ", _playerChar.get(0).heal()," Player Health is now :", _playerChar.get(0).getHealth());

    }
}