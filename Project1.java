import java.io.*;
import java.util.*;

// MODULE 4: OOP
class Candidate {
    String name; int votes = 0;
    Candidate(String n) { name = n; }
}

public class Project1 {
    // MODULE 1: Basics & I/O
    static boolean mod1(Scanner s, int voterNum) {
        System.out.print("\nVoter " + voterNum + " - Enter ID & Year (1-4): ");
        s.next(); 
        return s.nextInt() <= 4; // Returns true if eligible
    }

    // MODULE 2: Control Flow (Switch)
    static void mod2(Scanner s, Candidate a, Candidate b) {
        System.out.print("Vote 1 for " + a.name + "Vote 2 for " + b.name + ":\n ");
        switch(s.nextInt()) { 
            case 1: a.votes++; break; 
            case 2: b.votes++; break; 
            default: System.out.println("Invalid.");
        }
    }

    // MODULE 3: Arrays & Methods
    static int mod3(int[] arr) {
        int sum = 0;
        for (int v : arr) sum += v;
        return sum;
    }

    // MODULE 6: Collections & Streams
    static void mod6(Candidate a, Candidate b) {
        System.out.println("\n--- Final Results ---");
        Map.of(a.name, a.votes, b.name, b.votes).entrySet().stream()
        .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    // MODULE 5: File I/O
    static void mod5(int total) throws Exception {
        FileWriter f = new FileWriter("Report.txt");
        f.write("Total Votes Cast: " + total); 
        f.close();
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Candidate c1 = new Candidate("SRB\n"), c2 = new Candidate("CNI");
        
        // Ask for the number of voters upfront
        System.out.print("How many voters are participating? ");
        int totalVoters = sc.nextInt();
        
        // Loop exactly that many times
        for (int i = 1; i <= totalVoters; i++) {
            if (mod1(sc, i)) {
                mod2(sc, c1, c2);
            } else {
                System.out.println("Not eligible to vote.");
            }
        }
        
        // Process and show results after everyone has voted
        int total = mod3(new int[]{c1.votes, c2.votes});
        mod6(c1, c2);
        mod5(total);
    }
}