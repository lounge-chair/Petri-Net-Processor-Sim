import java.util.*;

import java.io.*;

class INM {
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

class INB {
    private boolean hasToken;
    private String opcode;
    private String destination;
    private int source1;
    private int source2;

    public INB() {
        hasToken = false; // Set the initial value for token
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

class AIB {
    private boolean hasToken;
    private String opcode;
    private String destination;
    private int source1;
    private int source2;

    public AIB() {
        hasToken = false; // Set the initial value for token
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

class SIB {

    private boolean hasToken;
    private String opcode;
    private String destination;
    private int source1;
    private int source2;

    public SIB() {
        hasToken = false; // Set the initial value for token
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

class PRB {
    private boolean hasToken;
    private String opcode;
    private String destination;
    private int source1;
    private int source2;

    public PRB() {
        hasToken = false; // Set the initial value for token
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

class ADB {
    private boolean hasToken;
    private String registerName;
    private int dataAddress;
    
    public boolean hasToken() {
        return this.hasToken;
    }

    public void setToken(boolean hasToken) {
        this.hasToken = hasToken;
    }

    public String getRegisterName() {
        return this.registerName;
    }

    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    public int getDataAddress() {
        return this.dataAddress;
    }

    public void setDataAddress(int dataAddress) {
        this.dataAddress = dataAddress;
    }
}

class REB {
    //private boolean hasToken;
    private String destination;
    private int value;

    // public REB() {
    //     hasToken = false; // Set the initial value for token
    // }

    // public boolean hasToken() {
    //     return this.hasToken;
    // }

    // public void setToken(boolean hasToken) {
    //     this.hasToken = hasToken;
    // }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int value) {
        this.value = value;
    }
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
    public static void main(String[] args) throws FileNotFoundException {
        // Declare files
        File instructions = new File("instructions.txt");
        File registers = new File("registers.txt");
        File datamemory = new File("datamemory.txt");
        PrintStream simulation = new PrintStream("simulation.txt");
        System.setOut(simulation);
        
        // Read in files
        ///////////////////////// INSTRUCTION MEMORY /////////////////////////
        ArrayDeque<INM> inm = new ArrayDeque<INM>(); // Declaraing instruction memory array (INM)
        INMsetup(instructions, inm);
        //////////////////////////

        ///////////////////////// REGISTER FILE ///////////////////////////////
        int[] rgf = new int[16]; // Instantiating register file place (RGF)
        Arrays.fill(rgf, -99); // Set default value to -99
        RGFsetup(registers, rgf); // Run setup function

        // DEBUG: CHECK RGF ARRAY
        // for (int j = 0; j < 16; j++) {
        //     System.out.println("registervalue at R" + j + " is " + rgf[j]);
        //     // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        // }
        //////////////////////////

        ///////////////////////// DATA MEMORY /////////////////////////////////
        int[] dam = new int[16]; // Instantiating data memory place (DAM)
        Arrays.fill(dam, -99); // Set default value to -99
        DAMsetup(datamemory, dam); // Run setup function

        // DEBUG: CHECK RGF ARRAY
        // for (int k = 0; k < 16; k++) {
        //     System.out.println("DATA at " + k + " is " + dam[k]);
        //     // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        // }
        //////////////////////////

        ///////////////////////// TRANSITIONS ////////////////////////////////
        int step = 0;
        INB inb = new INB();
        AIB aib = new AIB();
        SIB sib = new SIB();
        ArrayDeque<REB> reb = new ArrayDeque<REB>();
        PRB prb = new PRB();
        ADB adb = new ADB();

        boolean readDecodeFired, issue1Fired, issue2Fired, asuFired, mlu1Fired, mlu2Fired, addrFired, storeFired,
                writeFired, done = false;


        //Print 0 time step
        System.out.println("STEP " + step++ + ":");
        printSim(inm, inb, aib, sib, prb, adb, reb, rgf, dam, done);

        do {
            // SETUP ////////////////////////////////////////////
            System.out.println("\nSTEP " + step++ + ":");
            // Keeps track of whether or not any transition has fired this time step
            readDecodeFired = false;
            issue1Fired = false;
            issue2Fired = false;
            asuFired = false;
            mlu1Fired = false;
            mlu2Fired = false;
            addrFired = false;
            storeFired = false;
            writeFired = false;

            /////////////////////////////////////////////////////
            //WRITE
            writeFired = write(reb, rgf);
            //STORE
            storeFired = store(adb, rgf, dam);
            //ADDR
            addrFired = addr(sib,adb);
            //MLU2
            mlu2Fired = mlu2(prb, reb, rgf);
            // MLU1
            mlu1Fired = mlu1(aib, prb);
            // ASU (add/sub unit)
            asuFired = asu(aib, reb, rgf);
            // ISSUE2
            issue2Fired = issue2(inb, sib);
            // ISSUE1
            issue1Fired = issue1(inb, aib);
            // READ/DECODE
            readDecodeFired = readDecode(inb, inm, rgf);
            if (inm.isEmpty() == false) {
                inm.pop();
            }

            // TODO: WRITE

            // Print time step
            printSim(inm, inb, aib, sib, prb, adb, reb, rgf, dam, done);

            //DEBUG:
            // System.out.println("readDecodeFired is " + readDecodeFired);
            // System.out.println("issue1Fired is " + issue1Fired);
            // System.out.println("issue2Fired is " + issue2Fired);
            // System.out.println("asuFired is " + asuFired);
            // System.out.println("mlu1Fired is " + mlu1Fired);
            // System.out.println("mlu2Fired is " + mlu2Fired);
            // System.out.println("addrFired is " + addrFired);
            // System.out.println("storeFired is " + storeFired);
            // System.out.println("writeFired is " + writeFired);
            //

            if(done) {
                break;
            } else if(writeFired && !readDecodeFired && !issue1Fired && !issue2Fired && !asuFired && !mlu1Fired && !mlu2Fired && !addrFired && !storeFired){
                done = true;
            } 
        } while ((readDecodeFired == true) || (issue1Fired == true) || (issue2Fired == true) || (asuFired == true) || (mlu1Fired == true) || (mlu2Fired == true) || (addrFired == true) || (storeFired == true) || (writeFired == true));
    }

    public static void INMsetup(File instructions, Deque<INM> inm) {
        int instCount = 0;

        try {
            Scanner scan = new Scanner(instructions);

            while (scan.hasNextLine()) {
                if (instCount > 16) {
                    System.out.println("Too many instructions! Only 16 instructions can be inputted at once.");
                    System.exit(1);
                }
                INM tempINM = new INM();
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

    public static boolean readDecode(INB inb, Deque<INM> inm, int[] rgf) {
        // Check if there's an object in inm
        if (inm.isEmpty() == false) {
            // Perform operation
            inb.setOpcode(inm.peek().getOpcode());
            inb.setDestination(inm.peek().getDestination());
            inb.setSource1(rgf[Character.getNumericValue(inm.peek().getSource1().charAt(1))]);
            if (inm.peek().getSource2().charAt(0) == 'R') { // Check if source2 is register or immediate value
                inb.setSource2(rgf[Character.getNumericValue(inm.peek().getSource2().charAt(1))]);
            } else {
                inb.setSource2(Character.getNumericValue(inm.peek().getSource2().charAt(0)));
            }
            // Place token in inb
            inb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean issue1(INB inb, AIB aib) {
        // Check if inb has an arithmetic instruction token
        if (inb.hasToken()
                && (inb.getOpcode().equals("ADD") || inb.getOpcode().equals("SUB") || inb.getOpcode().equals("MUL"))) {
            // Take token from inb
            inb.setToken(false);
            // Perform operation
            aib.setOpcode(inb.getOpcode());
            aib.setDestination(inb.getDestination());
            aib.setSource1(inb.getSource1());
            aib.setSource2(inb.getSource2());
            // Place token in aib
            aib.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean issue2(INB inb, SIB sib) {
        // Check if inb has a store instruction token
        if (inb.hasToken() && (inb.getOpcode().equals("ST"))) {
            // Take token from inb
            inb.setToken(false);
            // Perform operation
            sib.setOpcode(inb.getOpcode());
            sib.setDestination(inb.getDestination());
            sib.setSource1(inb.getSource1());
            sib.setSource2(inb.getSource2());
            // Place token in aib
            sib.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean asu(AIB aib, ArrayDeque<REB> reb, int[] rgf) {
        // Check if aib has add or sub token
        if (aib.hasToken() && (aib.getOpcode().equals("ADD") || aib.getOpcode().equals("SUB"))) {
            // Take token from aib
            aib.setToken(false);
            // Perform operation
            REB tempreb = new REB();
            tempreb.setDestination(aib.getDestination());
            if (aib.getOpcode().equals("ADD")) {
                tempreb.setValue(aib.getSource1() + aib.getSource2());
            } else if (aib.getOpcode().equals("SUB")) {
                tempreb.setValue(aib.getSource1() - aib.getSource2());
            }
            reb.add(tempreb);
            // Place token in reb
            // reb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean mlu1(AIB aib, PRB prb) {
        // Check if aib has add or sub token
        if (aib.hasToken() && (aib.getOpcode().equals("MUL"))) {
            // Take token from aib
            aib.setToken(false);
            // Perform operation
            prb.setOpcode(aib.getOpcode());
            prb.setDestination(aib.getDestination());
            prb.setSource1(aib.getSource1());
            prb.setSource2(aib.getSource2());
            // Place token in prb
            prb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean mlu2(PRB prb, ArrayDeque<REB> reb, int[] rgf) {
        // Check if aib has add or sub token
        if (prb.hasToken() && (prb.getOpcode().equals("MUL"))) {
            // Take token from aib
            prb.setToken(false);
            // Perform operation
            REB tempreb = new REB();
            tempreb.setDestination(prb.getDestination());
            tempreb.setValue(prb.getSource1() * prb.getSource2());
            reb.add(tempreb);
            // Place token in reb
            //reb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean addr(SIB sib, ADB adb) {
        if (sib.hasToken()) {
            // Take token from aib
            sib.setToken(false);
            // Perform operation
            adb.setRegisterName(sib.getDestination());
            adb.setDataAddress(sib.getSource1()+sib.getSource2());
            // Place token in reb
            adb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }
    
    public static boolean store(ADB adb, int[] rgf, int[] dam) {
        if (adb.hasToken()) {
            // Take token from aib
            adb.setToken(false);
            // Perform operation
            //DEBUG:
            //System.out.println("Get data address: " + adb.getDataAddress());
            //System.out.println("Get register int: " + adb.getRegisterName().charAt(1));
            //
            dam[adb.getDataAddress()] = rgf[Character.getNumericValue(adb.getRegisterName().charAt(1))];
            // Place token in reb
            //adb.setToken(true);
            // Transition fired
            return true;
        } else {
            return false;
        }
    }

    public static boolean write(ArrayDeque<REB> reb, int[] rgf) {
        if (reb.isEmpty() == false) {
                //DEBUG:
                //System.out.println("REB destination is " + Character.getNumericValue(reb.peek().getDestination().charAt(1)));
                //System.out.println("REB value is " + reb.peek().getValue());
                //
                //int length = reb.peek().getDestination().length();
                rgf[Integer.parseInt(reb.peek().getDestination().replaceAll("R", ""))] = reb.peek().getValue();
                reb.pop();
            return true;
        } else {
            return false;
        }
        
    }
    public static void printSim(ArrayDeque<INM> inm, INB inb, AIB aib, SIB sib, PRB prb, ADB adb, ArrayDeque<REB> reb, int[] rgf, int[] dam, boolean done) {
        // Print INM
        Deque<INM> tempinm = inm.clone();
        boolean first = true;
        System.out.print("INM:");
        while (tempinm.isEmpty() == false) {
            if (!first) {
                System.out.print(",");
            } else {
                first = false;
            }
            System.out.print("<" + tempinm.peek().getOpcode() + ",");
            System.out.print(tempinm.peek().getDestination() + ",");
            System.out.print(tempinm.peek().getSource1() + ",");
            System.out.print(tempinm.peek().getSource2() + ">");
            tempinm.pop();
        }
        System.out.print("\n");

        // Print INB
        System.out.print("INB:");
        if (inb.hasToken()) {
            System.out.print("<" + inb.getOpcode() + ",");
            System.out.print(inb.getDestination() + ",");
            System.out.print(inb.getSource1() + ",");
            System.out.print(inb.getSource2() + ">");
        }
        System.out.print("\n");

        // Print AIB
        System.out.print("AIB:");
        if (aib.hasToken()) {
            System.out.print("<" + aib.getOpcode() + ",");
            System.out.print(aib.getDestination() + ",");
            System.out.print(aib.getSource1() + ",");
            System.out.print(aib.getSource2() + ">");
        }
        System.out.print("\n");

        // Print SIB
        System.out.print("SIB:");
        if (sib.hasToken()) {
            System.out.print("<" + sib.getOpcode() + ",");
            System.out.print(sib.getDestination() + ",");
            System.out.print(sib.getSource1() + ",");
            System.out.print(sib.getSource2() + ">");
        }
        System.out.print("\n");

        // Print PRB
        System.out.print("PRB:");
        if (prb.hasToken()) {
            System.out.print("<" + prb.getOpcode() + ",");
            System.out.print(prb.getDestination() + ",");
            System.out.print(prb.getSource1() + ",");
            System.out.print(prb.getSource2() + ">");
        }
        System.out.print("\n");

        // TODO: Print ADB
        System.out.print("ADB:");
        if (adb.hasToken()) {
            System.out.print("<" + adb.getRegisterName() + ",");
            System.out.print(adb.getDataAddress() + ">");
        }
        System.out.print("\n");

        // Print REB
        Deque<REB> tempreb = reb.clone();
        first = true;
        System.out.print("REB:");
        while (tempreb.isEmpty() == false) {
            if (!first) {
                System.out.print(",");
            } else {
                first = false;
            }
            System.out.print("<" + tempreb.peek().getDestination() + ",");
            System.out.print(tempreb.peek().getValue() + ">");
            tempreb.pop();
        }
        System.out.print("\n");

        // Print RGF
        first = true;
        System.out.print("RGF:");
        for (int g = 0; g < 16; g++) {
            if (rgf[g] != -99) {
                if (!first) {
                    System.out.print(",");
                } else {
                    first = false;
                }
                System.out.print("<R" + g + "," + rgf[g] + ">");

            }
        }
        System.out.print("\n");

        // Print DAM
        first = true;
        System.out.print("DAM:");
        for (int d = 0; d < 16; d++) {
            if (dam[d] != -99) {
                if (!first) {
                    System.out.print(",");
                } else {
                    first = false;
                }
                System.out.print("<" + d + "," + dam[d] + ">");

            }
        }
        if(!done) {
            System.out.print("\n");
        }
    }

}
