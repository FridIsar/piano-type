import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class MidiPlayback {
    public static void main(String[] args) {
        try {
            Sequencer sequencer = MidiSystem.getSequencer(); // Get the default Sequencer
            if (sequencer==null) {
                System.err.println("Sequencer device not supported");
                return;
            }
            sequencer.open(); // Open device
            // Create sequence, the File must contain MIDI file data.
            Sequence sequence = MidiSystem.getSequence(new File("midifile.mid"));
            sequencer.setSequence(sequence); // load it into sequencer

            // long i = 0;
            // for (i)
            // sequencer.setLoopStartPoint(i);
            // i+=1000;
            // sequencer.setLoopEndPoint(i);
            sequencer.setTickPosition(6000);
            sequencer.start();  // start the playback
            boolean playback = true;
            while (playback)  {
              System.out.println(sequencer.getTickPosition());
              if (sequencer.getTickPosition() >= 9000)  {
                playback = false;
              }
            }
            sequencer.stop();
            System.out.println("fin");
            sequencer.close();

        } catch (MidiUnavailableException | InvalidMidiDataException | IOException ex) {
            ex.printStackTrace();
        }
    }
}
