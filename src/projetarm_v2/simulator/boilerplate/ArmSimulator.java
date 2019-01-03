package projetarm_v2.simulator.boilerplate;

import projetarm_v2.simulator.core.Cpu;
import projetarm_v2.simulator.core.Program;

/**
 * ArmSimulator is class responsible for handling the creation of the main ARM Simulator classes.
 */
public class ArmSimulator {
    /**
     * The current loaded program
     */
	private final Program program;

    /**
     * The cpu to execute the prorgam
     */
	private final Cpu cpu;


    /**
     * Creates a arm simulator ready to use, with all the needed components (cpu, program, linesMap, interpretor)
     */
	public ArmSimulator() {	
		this.cpu = new Cpu();
		this.program = new Program();
	}

    /**
     * Returns the register value corresponding to the given number
     */
	public int getRegisterValue(int registerNumber) {
		return this.cpu.getRegister(registerNumber).getValue();
	}

    /**
     * Returns a byte(8bits) from the ram corresponding to the given address
     */
	public byte getRamByte(long address) {
		return this.cpu.getRam().getByte(address);
	}

    /**
     * Returns a half-word(16bits) from the ram corresponding to the given address
     */
	public short getRamHWord(long address) {
		return this.cpu.getRam().getHWord(address);
	}
	
    /**
     * Returns a word(32bits) from the ram corresponding to the given address
     */
	public int getRamWord(long address) {
		return this.cpu.getRam().getValue(address);
	}

    /**
     * Starting the processor to the next break or to the end
     */
	public void run() {
		this.cpu.runAllAtOnce();
	}

    /**
     * Staring the processor to execute a single instruction
     */
	public void runStep(){
		this.cpu.runStep();
	}

    /**
     * Resets the execution (clears the current execution point)
     */
	public void resetRun(){
		// TODO
	}

    /**
     * Returns the Negative Flag status
     */
	public boolean getN() {
		return this.cpu.getCPSR().n();
	}

    /**
     * Returns the Zero Flag status
     */
	public boolean getZ() {
		return this.cpu.getCPSR().z();
	}

    /**
     * Returns the Carry Flag status
     */
	public boolean getC() {
		return this.cpu.getCPSR().c();
	}

    /**
     * Returns the oVerflow Flag status
     */
	public boolean getV() {
		return this.cpu.getCPSR().v();
	}

    /**
     * Returns true if the cpu is halted
     */
	public boolean isHalted() {
		return this.cpu.isRunning();
	}

	/**
     * Stops the execution
     */
	public void interruptExecutionFlow() {
		this.cpu.interruptMe();
	}
}
