/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package z80core;

public interface IMemIoOps {

    int fetchOpcode(int address);

    int peek8(int address);

    void poke8(int address, int value);

    default int peek16(int address) {
        int lsb = peek8(address);
        int msb = peek8(address + 1);
        return (msb << 8) | lsb;
    }

    default void poke16(int address, int word) {
        poke8(address, word);
        poke8(address + 1, word >>> 8);
    }

    int inPort(int port);

    void outPort(int port, int value);

    void addressOnBus(int address, int tstates);

    default int getAddressOnBus(){
        return 0xFF;
    }

    void interruptHandlingTime(int tstates);

    boolean isActiveINT();

    boolean setActiveINT(boolean val);

    long getTstates();

    void reset();

    default int getPcUpperLimit(){
        return 0xFFFF;
    }
}
