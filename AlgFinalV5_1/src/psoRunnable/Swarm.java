/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package psoRunnable;

import java.util.ArrayList;
import ui.Resultset;
import static ui.Resultset.resultSet;

/**
 *
 * @author Lig37
 */
public class Swarm {

    double swarmPriceMin;
    double swarmPriceMax;
    private ArrayList<Agent> myRunnable = new ArrayList<Agent>();
    private ArrayList<Thread> threads = new ArrayList<Thread>();//30-50 agents = new Agent[50] = new Thread[50]
    // Vector<Seller> swarm = new Vector<Seller>();

    public ArrayList<Agent> getMyRunnable() {
        return myRunnable;
    }

    public void setMyRunnable(ArrayList<Agent> myRunnable) {
        this.myRunnable = myRunnable;
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }

    public void setThreads(ArrayList<Thread> threads) {
        this.threads = threads;
    }

    //constructor
    public Swarm(int SWARM_SIZE, double estimateRev, double LOC_Y_LOW, double LOC_Y_HIGH) {

        this.swarmPriceMin = LOC_Y_LOW;
        this.swarmPriceMax = LOC_Y_HIGH;
        for (int i = 0; i < SWARM_SIZE; i++) {
            myRunnable.add(i, new Agent(estimateRev, LOC_Y_LOW, LOC_Y_HIGH));
            resultSet.add(myRunnable.get(i));
            threads.add(i, new Thread(myRunnable.get(i)));
            threads.get(i).setName("Seller #" + i);
            int priority;
            if (i % 10 == 0) {
                priority = i % 10 + 1;
            } else {
                priority = i % 10;
            }
            threads.get(i).setPriority(priority);
            System.out.println("finish creating threads" + threads.get(i).getName());
        }
    }
}
