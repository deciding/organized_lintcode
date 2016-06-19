//iterative*33, calculate mode for every mul and add, in case overflow
class Solution {
    /**
     * @param key: A String you should hash
     * @param HASH_SIZE: An integer
     * @return an integer
     */
    // key !! in case overflow
    // design 33 based multiply !!
    // hash for every plus sign !!
    public int hashMul(int n,int HASH_SIZE){
		int total=0;
		for(int i=0;i<33;i++){
			total=(total+n)%HASH_SIZE;
		}
		return total;
	}
	public int hashCode(char[] key,int HASH_SIZE) {
        // write your code here
		int total=0;
		for(int i=0;i<key.length;i++){
			total=hashMul(total,HASH_SIZE);
			total=(total+key[i])%HASH_SIZE;
		}
		return total;
    }
};