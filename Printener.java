import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.io.File;
import java.io.IOException;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;

public class Printener {

    public static void main(String args[]) {

			MidiPlayback midi = new MidiPlayback();

  JFrame frame = new JFrame("Key Listener");

  Container contentPane = frame.getContentPane();

  KeyListener listener = new KeyListener() {

@Override

public void keyPressed(KeyEvent event) {

    printEventInfo("Key Pressed", event);
		midi.playbit();
}

@Override

public void keyReleased(KeyEvent event) {

    printEventInfo("Key Released", event);

}

@Override

public void keyTyped(KeyEvent event) {

    printEventInfo("Key Typed", event);

}

private void printEventInfo(String str, KeyEvent e) {

    System.out.println(str);

    int code = e.getKeyCode();

    System.out.println("   Code: " + KeyEvent.getKeyText(code));

    System.out.println("   Char: " + e.getKeyChar());

    int mods = e.getModifiersEx();

    System.out.println("    Mods: "

+ KeyEvent.getModifiersExText(mods));

    System.out.println("    Location: "

+ keyboardLocation(e.getKeyLocation()));

    System.out.println("    Action? " + e.isActionKey());

}

private String keyboardLocation(int keybrd) {

    switch (keybrd) {

  case KeyEvent.KEY_LOCATION_RIGHT:

return "Right";

  case KeyEvent.KEY_LOCATION_LEFT:

return "Left";

  case KeyEvent.KEY_LOCATION_NUMPAD:

return "NumPad";

  case KeyEvent.KEY_LOCATION_STANDARD:

return "Standard";

  case KeyEvent.KEY_LOCATION_UNKNOWN:

  default:

return "Unknown";

    }

}

  };

  JTextField textField = new JTextField();

  textField.addKeyListener(listener);

  contentPane.add(textField, BorderLayout.NORTH);

  frame.pack();

  frame.setVisible(true);

    }
}


// import java.awt.BorderLayout;
// import java.awt.Container;
// import java.awt.event.KeyEvent;
// import java.awt.event.KeyListener;
//
// import javax.swing.JFrame;
// import javax.swing.JTextField;
//
// public class Printener implements KeyListener	{
// 	public Printener()	{
// 		JFrame frame = new JFrame("Key Listener");
//
//   	Container contentPane = frame.getContentPane();
//
//   	KeyListener listener = new KeyListener()
// 	}
//
// 	public void init()	{
// 		// this.addKeyListener(this);
// 	}
//
// 	public void keyPressed(KeyEvent e)	{
// 		System.out.println("enfoncement "+e);
// 	}
//
// 	public void keyReleased(KeyEvent e)	{
// 		System.out.println("desenfoncement "+e);
// 	}
//
// 	public void keyTyped(KeyEvent e)	{
// 		System.out.println("reenfoncement "+e);
// 	}
// }
