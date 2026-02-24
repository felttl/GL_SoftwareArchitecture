package archi;

import java.RedPlayer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import archi.model.Customers;
import archi.model.Movie;
import archi.model.Rental;
import archi.model.SuperCustomer;
import archi.player.Player;
import archi.view.VCustomer.FXCustomer;
import javafx.application.Application;

/**
 * openjdk 21.0.9 2025-10-21
 * OpenJDK Runtime Environment (build 21.0.9+-14649483-b1163.86)
 * OpenJDK 64-Bit Server VM (build 21.0.9+-14649483-b1163.86, mixed mode)
 */
public class App {
    public static void main(String[] args) {
        Player bp = new BluePlayer();
        Player rp = new RedPlayer();
        while(bp.isAlive() && rp.isAlive()){
            bp.parry()
        }
    }
}
