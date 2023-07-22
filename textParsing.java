
public class Main {
    public static void main(String[] args) {
       String testString = "c\\u0007De\\u0003c\\u0001loak";
       String currCode = "";
       String prevCode = "";
       String HTMLString = "<html><body>";
       String HTMLColor = "";
       String hotkey = String.valueOf(testString.charAt(0));
       System.out.println("Hotkey: " + hotkey);
       for (int i = 1; i < testString.length(); i++){
           if(String.valueOf(testString.charAt(i)).equals("\\")){
               if(String.valueOf(testString.charAt(i)).equals("\\") && String.valueOf(testString.charAt(i+1)).equals("n")){
                   HTMLString += "<br></br>";
                   i += 2;
               } else {
                   if (currCode.equals("")){
                       currCode = testString.substring(i, i+6);
                   } else if(testString.substring(i, i+6).equals("\\u0001")){
                       currCode = prevCode;
                   } else {
                       prevCode = currCode;
                       currCode = testString.substring(i, i+6);
                   }
                   i += 6;
               }
           }
           if(currCode.equals("\\u0000")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0001")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0002")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0003")){
               HTMLColor = "DCDC3C";
           }
           if(currCode.equals("\\u0004")){
               HTMLColor = "FFFFFF";
           }
           if(currCode.equals("\\u0005")){
               HTMLColor = "847474";
           }
           if(currCode.equals("\\u0006")){
               HTMLColor = "C81818";
           }
           if(currCode.equals("\\u0007")){
               HTMLColor = "10FC18";
           }
           if(currCode.equals("\\u0008")){
               HTMLColor = "F40404";
           }
           if(currCode.equals("\\u0009")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u000A")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u000B")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u000C")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u000D")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u000E")){
               HTMLColor = "0C48CC";
           }
           if(currCode.equals("\\u000F")){
               HTMLColor = "2CB494";
           }
           if(currCode.equals("\\u0010")){
               HTMLColor = "88409C";
           }
           if(currCode.equals("\\u0011")){
               HTMLColor = "F88C14";
           }
           if(currCode.equals("\\u0012")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0013")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0014")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u0015")){
               HTMLColor = "703014";
           }
           if(currCode.equals("\\u0016")){
               HTMLColor = "CCE0D0";
           }
           if(currCode.equals("\\u0017")){
               HTMLColor = "FCFC38";
           }
           if(currCode.equals("\\u0018")){
               HTMLColor = "088008";
           }
           if(currCode.equals("\\u0019")){
               HTMLColor = "FCFC7C";
           }
           if(currCode.equals("\\u001A")){
               HTMLColor = "B8B8E8";
           }
           if(currCode.equals("\\u001B")){
               HTMLColor = "ECC4B0";
           }
           if(currCode.equals("\\u001C")){
               HTMLColor = "4068D4";
           }
           if(currCode.equals("\\u001D")){
               HTMLColor = "74A47C";
           }
           if(currCode.equals("\\u001E")){
               HTMLColor = "9090B8";
           }
           if(currCode.equals("\\u001F")){
               HTMLColor = "00E4FC";
           }
           HTMLString += "<div style='display: inline; color:#" + HTMLColor + "'>" + testString.charAt(i) + "</div>";
       }
       HTMLString += "</body></html>";
       System.out.println(HTMLString);
    }
}
