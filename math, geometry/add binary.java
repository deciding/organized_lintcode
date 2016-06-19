//408
public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
     
    public String addBinary(String a, String b) {
        // Write your code here
        int c=0;
        int len=b.length();
        String r=new String("");
        if(a.length()<b.length()){
            len=b.length();
            for(int i=b.length()-a.length();i>0;i--)
                a="0"+a;
        }
        else if(b.length()<a.length()){
            len=a.length();
            for(int i=a.length()-b.length();i>0;i--)
                b="0"+b;
        }
        
        for(int i=len-1;i>=0;i--){
            int ai=Character.getNumericValue(a.charAt(i));
            int bi=Character.getNumericValue(b.charAt(i));
            if(ai+bi+c==0){
                r="0"+ r;
                c=0;
            }
            else if(ai+bi+c==1){//must use else if
                r="1"+ r;
                c=0;// must reet c
            }
            else if(ai+bi+c==2){
                r="0"+ r;
                c=1;
            }
            else if(ai+bi+c==3){
                r="1"+ r;
                c=1;
            }
        }
        if(c==1)
            r="1"+r;
        return r;
    }
}
