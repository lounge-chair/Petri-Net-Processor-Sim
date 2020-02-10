import java.util.*;
import java.io.*;

class inm {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * Source Operand - String 4. Second Source Operand - String
     */
    private String opcode;
    private String destination;
    private String source1;
    private String source2;

    public String getOpcode() {
        return this.opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource1() {
        return this.source1;
    }

    public void setSource1(String source1) {
        this.source1 = source1;
    }

    public String getSource2() {
        return this.source2;
    }

    public void setSource2(String source2) {
        this.source2 = source2;
    }
}

class inb {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
    private boolean hasToken;
    private String opcode;
    private String destination;
    private int source1;
    private int source2;

    public inb() {
        hasToken = false;  // Set the initial value for token
    }

    public boolean hasToken() {
        return this.hasToken;
    }

    public void setToken(boolean hasToken) {
        this.hasToken = hasToken;
    }

    public String getOpcode() {
        return this.opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getSource1() {
        return this.source1;
    }

    public void setSource1(int source1) {
        this.source1 = source1;
    }

    public int getSource2() {
        return this.source2;
    }

    public void setSource2(int source2) {
        this.source2 = source2;
    }

}

class aib {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class sib {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class prb {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class adb {
    /*
     * 2 attributes: 1. Register name - String 2. Data memory address - int
     */
}

class reb {
    /*
     * 2 attributes: 1. register name - String 2. register value - int
     */
}
// class rgf
// {
// /*
// 2 attributes:
// 1. register name - String
// 2. register value - int
// */
// }

// class dam
// {
// /*
// 2 attributes:
// 1. address - int
// 2. value - int
// */
// }

public class Psim {
    public static void main(String[] args) {
        // Declare files
        File instructions = new File("instructions.txt");
        File registers = new File("registers.txt");
        File datamemory = new File("datamemory.txt");

        // Read in files
        ///////////////////////// INSTRUCTION MEMORY /////////////////////////
        Deque<inm> inm = new ArrayDeque<inm>(); // Declaraing instruction memory array (INM)
        INMsetup(instructions, inm);
        //////////////////////////

        ///////////////////////// REGISTER FILE ///////////////////////////////
        int[] rgf = new int[16]; // Instantiating register file place (RGF)
        Arrays.fill(rgf, -99); // Set default value to -99
        RGFsetup(registers, rgf); // Run setup function

        // DEBUG: CHECK RGF ARRAY
        for (int j = 0; j < 16; j++) {
            System.out.println("registervalue at R" + j + " is " + rgf[j]);
            // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        }
        //////////////////////////

        ///////////////////////// DATA MEMORY /////////////////////////////////
        int[] dam = new int[16]; // Instantiating data memory place (DAM)
        Arrays.fill(dam, -99); // Set default value to -99
        DAMsetup(datamemory, dam); // Run setup function

        // DEBUG: CHECK RGF ARRAY
        for (int k = 0; k < 16; k++) {
            System.out.println("DATA at " + k + " is " + dam[k]);
            // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        }
        //////////////////////////

        ///////////////////////// TRANSITIONS /////////////////////////
        boolean fired = false;
        int step = 0;
        inb inb = new inb();
        do {
            //SETUP//////////////////////////////////////////////
            System.out.println("\nSTEP " + step++ + ":");
            fired = false;
            /////////////////////////////////////////////////////

            //READ/DECODE
            if(inm.isEmpty() == false) {
                fired = true;
                //DEBUG:
                System.out.println("DECODE OPCODE IS: " + inm.peek().getOpcode());
                System.out.println("DECODE DEST IS: " + inm.peek().getDestination());
                System.out.println("DECODE S1 IS: " + inm.peek().getSource1());
                System.out.println("DECODE S2 IS: " + inm.peek().getSource2());
                //
                inb.setOpcode(inm.peek().getOpcode());
                inb.setDestination(inm.peek().getDestination());
                inb.setSource1(rgf[Character.getNumericValue(inm.peek().getSource1().charAt(1))]);
                if(inm.peek().getSource2().charAt(0) == 'R') { //Check if source2 is register or immediate value
                    inb.setSource1(rgf[Character.getNumericValue(inm.peek().getSource2().charAt(1))]);
                } else {
                    inb.setSource2(Character.getNumericValue(inm.peek().getSource2().charAt(0)));
                }
                inb.setToken(true);
                //DEBUG:
                System.out.println("READ OPCODE IS: " + inb.getOpcode());
                System.out.println("READ DEST IS: " + inb.getDestination());
                System.out.println("READ S1 IS: " + inb.getSource1());
                System.out.println("READ S2 IS: " + inb.getSource2());
                //
            }
            // TODO: ISSUE1
            // TODO: ISSUE2
            // TODO: ASU (add/sub unit)
            // TODO: MLU1
            // TODO: MLU2
            // TODO: ADDR (address calculation)
            // TODO: STORE
            // TODO: WRITE

            if(inm.isEmpty() == false) {
            inm.pop();
            }
        } while (fired == true);
    }

    public static void INMsetup(File instructions, Deque<inm> inm) {
        // for (int i = 0; i < inm.length; i++) { // Creating INM objects

        // }

        int instCount = 0;

        // read
        try {
            Scanner scan = new Scanner(instructions);

            while (scan.hasNextLine()) {
                if (instCount > 16) {
                    System.out.println("Too many instructions! Only 16 instructions can be inputted at once.");
                    System.exit(1);
                }
                inm tempINM = new inm();
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<", "").replaceAll("\\>", "").split(",");
                // Accesses temp array to set values in INM
                tempINM.setOpcode(temp[0]);
                tempINM.setDestination(temp[1]);
                tempINM.setSource1(temp[2]);
                tempINM.setSource2(temp[3]);

                inm.add(tempINM);
            }
            scan.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void RGFsetup(File registers, int[] rgf) {
        try {
            Scanner scan = new Scanner(registers);

            while (scan.hasNextLine()) {
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<R", "").replaceAll("\\>", "").split(",");
                // Use temporary array to fill indexes with their proper values
                rgf[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void DAMsetup(File datamemory, int[] dam) {
        try {
            Scanner scan = new Scanner(datamemory);

            while (scan.hasNextLine()) {
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<", "").replaceAll("\\>", "").split(",");
                // Use temporary array to fill indexes with their proper values
                dam[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}