public class Convert{

   /** EPSILON is used to check is two doubles are 
       close enough to each other to be considered the same
   */
   public static final double EPSILON = 0.000001;
   
   /** QUIET is used to display less information when testing */
   public static boolean QUIET = false;





   public static double convert(String temperature, char scale){
      // converts a temperature (value/scale) to a new scale
      
      int x = temperature.length(); 
      char c = temperature.charAt(x-1);

      if((c == 'C') && (scale == 'C' || scale == 'c')){
         String str = temperature.substring(0, temperature.length() - 1);
         double num = Double.parseDouble(str);
         if (num < -273.15){
            return -273.15;
         }
         return num;
      }

      if((c == 'F') && (scale == 'F' || scale == 'f')){
         String str = temperature.substring(0, temperature.length() - 1);
         double num = Double.parseDouble(str);
         if (num < -459.67){
            return -459.67;
         }
         return num;
      }
      
      if((c == 'C') && (scale == 'F' || scale == 'f')) {
         String str = temperature.substring(0, temperature.length() - 1);
         double num = Double.parseDouble(str);
         double num1 = (num * (9.0/5.0) + 32); 
         if (num1 < -459.67){
            return -459.67;
         }
         return num1;
      }
      if((c == 'F') && (scale == 'C' || scale == 'c')){
         String str = temperature.substring(0, temperature.length() - 1);
         double num = Double.parseDouble(str);
         double num2 = (num - 32) * (5.0/9.0); 
         if (num2 < -273.15){
            return -273.15;
         }
         return num2;
      }
      String str = temperature.substring(0, temperature.length() - 1);
      double num = Double.parseDouble(str);
      return num;
   }







   /*
    The main method is here for you test your code. 
    It is NOT part of the actual assignment 
    */

    public static void main(String[] args){
      System.out.println("Testing Convert.convert");
      String in = "10.0C";
      char scale = 'F';
      double expect = 50.0;
      double out = Convert.convert(in, scale);
      System.out.print("convert(\"" + in + "\",\'" + scale + "\')  ");
      if( Math.abs(expect-out)<EPSILON){
         System.out.println("[passed]");        
      }else{
         System.out.println("[failed]");  
         if(!QUIET){System.out.println("...expect : " + expect);}
         if(!QUIET){System.out.println("...actual : " + out);}

      }
      
      
      
      in = "10.0C";
      scale = 'C';
      expect = 10.0;
      out = Convert.convert(in, scale);
      System.out.print("convert(\"" + in + "\",\'" + scale + "\')  ");
      if( Math.abs(expect-out)<EPSILON){
         System.out.println("[passed]");        
      }else{
         System.out.println("[failed]");        
         if(!QUIET){System.out.println("...expect : " + expect);}
      if(!QUIET){System.out.println("...actual : " + out);}
      }

      in = "50.0F";
      scale = 'C';
      expect = 10.0;
      out = Convert.convert(in, scale);
      System.out.print("convert(\"" + in + "\",\'" + scale + "\')  ");
      if( Math.abs(expect-out)<EPSILON){
         System.out.println("[passed]");        
      }else{
         System.out.println("[failed]");        
         if(!QUIET){System.out.println("...expect : " + expect);}
      if(!QUIET){System.out.println("...actual : " + out);}
      }

      in = "50.0F";
      scale = 'F';
      expect = 50.0;
      out = Convert.convert(in, scale);
      System.out.print("convert(\"" + in + "\",\'" + scale + "\')  ");
      if( Math.abs(expect-out)<EPSILON){
         System.out.println("[passed]");        
      }else{
         System.out.println("[failed]");        
         if(!QUIET){System.out.println("...expect : " + expect);}
      if(!QUIET){System.out.println("...actual : " + out);}
      }
   }
}