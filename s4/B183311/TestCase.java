package s4.B183311; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;

/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {
	try {
	    FrequencerInterface  myObject;
	    int freq;
		System.out.println("checking s4.B183311.Frequencer");
		
		// TARGETが設定されていない
	    System.out.print("No TARGET:");
		myObject = new s4.B183311.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
		freq = myObject.frequency();
		if (freq == -1){
			System.out.println("-1 OK!");
		}else{
			System.out.println("Failed.");
		}

		// TARGETの長さがゼロ
	    System.out.print("TARGET's length is zero:");
		myObject = new s4.B183311.Frequencer();
		myObject.setSpace("Hi Ho Hi Ho".getBytes());
		myObject.setTarget("".getBytes());
		freq = myObject.frequency();
		if (freq == -1){
			System.out.println("-1 OK!");
		}else{
			System.out.println("Failed.");
		}

		// SPACEが設定されていない
	    System.out.print("No SPACE:");
		myObject = new s4.B183311.Frequencer();
	    myObject.setTarget("H".getBytes());
		freq = myObject.frequency();
		if (freq == 0){
			System.out.println("0 OK!");
		}else{
			System.out.println("Failed.");
		}

		// SPACEの長さがゼロ
	    System.out.print("SPACE's length is zero:");
		myObject = new s4.B183311.Frequencer();
		myObject.setSpace("".getBytes());
		myObject.setTarget("H".getBytes());
		freq = myObject.frequency();
		if (freq == 0){
			System.out.println("0 OK!");
		}else{
			System.out.println("Failed.");
		}

	    myObject = new s4.B183311.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(4 == freq) { System.out.println("OK"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	try {
	    InformationEstimatorInterface myObject;
	    double value;
		System.out.println("checking s4.B183311.InformationEstimator");
		
		// TARGETが設定されていない
		System.out.println("No TARGET:");
		myObject = new s4.B183311.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
		value = myObject.estimation();
		if(value == 0.0){
			System.out.println("0.0 OK!");
		}else{
			System.out.println("Failed.");
		}

		// TARGETの長さがゼロ
		System.out.println("TARGET's lengsth is zero:");
		myObject = new s4.B183311.InformationEstimator();
		myObject.setSpace("3210321001230123".getBytes());
		myObject.setTarget("".getBytes());
		value = myObject.estimation();
		if(value == 0.0){
			System.out.println("0.0 OK!");
		}else{
			System.out.println("Failed.");
		}

		// true値が無限大

		// SPACEが設定されていない
		System.out.println("No SPACE:");
		myObject = new s4.B183311.InformationEstimator();
		myObject.setTarget("00".getBytes());
		value = myObject.estimation();
		if(value == Double.MAX_VALUE){
			System.out.println("Double.MAX_VALUE OK!");
		}else{
			System.out.println("Failed.");
		}

		// SPACEの長さがゼロ
		System.out.println("SPACE's length is zero:");
		myObject = new s4.B183311.InformationEstimator();
		myObject.setSpace("".getBytes());
		myObject.setTarget("00".getBytes());
		value = myObject.estimation();
		if(value == 0.0){
			System.out.println("Double.MAX_VALUE OK!");
		}else{
			System.out.println("Failed.");
		}

	    myObject = new s4.B183311.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());
	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);
	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);
	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);
	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

    }
}	    
	    
