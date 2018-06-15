
 import java.io.IOException; 
import org.apache.pig.EvalFunc;
 import org.apache.pig.data.DataByteArray;
import org.apache.pig.data.Tuple;
/** * Used Defined Function in Pig to covert given string argument into Upper Case *  */ 
public class ToUpper extends EvalFunc<String> { 
   /**     * Pig hands over the tuple instead of specific arguement, we need to get     * the specific attribute from tuple by calling tuple.get() method     *      */   
 @Override    public String exec(Tuple input) throws IOException {  
      if (null == input || input.size() == 0)
 {            return null;        }      
  try {  
          DataByteArray name = (DataByteArray) input.get(0);     
       return name.toString().toUpperCase();        
} catch (Exception e) {       
     throw new IOException("Caught exception while processing ", e);        }    } } 

