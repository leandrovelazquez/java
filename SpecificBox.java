public class SpecificBox extends Box{


   /* ------------------------------------------------------------
       Please NOTE the ordering of the input parameters
    -------------------------------------------------------------*/


   public SpecificBox(String label, String location, int size){
      // add code here

       super(label, location, size);
   }

   public int compareTo(Box Y){

      int loc = this.getLocation().compareTo(Y.getLocation());
      int labX = this.getLabel().length();
      int labY = Y.getLabel().length();
      int szX = this.getSize();
      int szY = Y.getSize();

      if (loc < 0){
         return -1;
      }
      if (loc > 0){
         return 1;
      }
      if (loc == 0){

         if (labX < labY){
            return -2;
         }

         if (labX > labY){
            return 2;
         }

         if (labX == labY){
            
            if (szX > szY){
               return -3;
            }

            if (szX < szY){
               return 3;
            }
            
            if (szX == szY){
               return 0;
            }
         }
      }
      return 0;
   }

}