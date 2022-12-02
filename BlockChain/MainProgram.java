
package proyecto;
//MIEMBROS DEL EQUIPO   
//Espinoza Rivera Saul
//Villa Preciado Pedro
//Borbon Avitia Omar
//Martinez Espinoza Eduardo
public class MainProgram{  
  
    public static void main(String[] args) {  
        //primero que todo instanciamos la clase blockchain  
        BlockChain blockChain = new BlockChain();  
        //vamos a instancias la clase minera para buscar el menor objeto  
        Miner miner = new Miner();  
        //tenemoe creado el bloque genesis o bloque 0
        //entonces le pasamos el id, la transacccion string y el hash anterior
        //como esto es el primer bloque entonces enemos que darle manualmente el hash anterior    
Block block0 = new Block(0,"transaccion",Constants.GENESIS_PREV_HASH);  
   
        //miner toma la transaccion y mina el bloque
        //para encontrar el valor hash y el miner agregara el bloque al blockchain
        miner.mine(block0, blockChain);  
          
        //creamos el siguiente bloque   
        //se pasa el id, el hash anterior  
        // da el hash valor y el de la cabeza en este caso llamado genesis  
Block block1 = new Block(1,"transaccion2",blockChain.getBlockChain().get(blockChain.size()-1).getHash());  
  
        miner.mine(block1, blockChain);  
  
        Block block2 = new Block (2,"transaccion3",blockChain.getBlockChain().get(blockChain.size()-1).getHash());  
    miner.mine(block2, blockChain);  
    System.out.println("\n"+ "BLOCKCHAIN:\n"+blockChain);  
    System.out.println("Recompensa de minado: " + miner.getReward());  
    }  
  
}  
