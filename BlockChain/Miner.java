
package proyecto;

public class Miner {  
  
    private double reward;    
  
    public void mine(Block block, BlockChain blockChain) {  
  
        while(notGoldenHash(block)) {  
            //generando el bloque hash 
            block.generateHash();  
            block.incrementNonce();  
        }  
  
        System.out.println(block+" acaba de minar...");  
        System.out.println("Hash es: "+block.getHash());          
        //agregando el bloque al blockchain  
blockChain.addBlock(block);  
        //calculando recompensa  
        reward+=Constants.MINER_REWARD;  
  
    }  
    //entonces miners va a generar un valor hash antes de encontrar el hash correcto
    //entonces va a encontrar con dificultad la variable declarada en la clase constant
 
    public boolean notGoldenHash(Block block) {  
  
        String leadingZeros = new String(new char[Constants.DIFFICULTY]).replace('\0', '0');  
  
        return !block.getHash().substring (0, Constants.DIFFICULTY).equals (leadingZeros);  
    }  
    public double getReward() {  
        return this.reward;  
    }  
  
}  