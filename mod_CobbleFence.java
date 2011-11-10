package net.minecraft.src;

import java.util.Map;

import org.lwjgl.opengl.GL11;

public class mod_CobbleFence extends BaseMod
{	
    public static final Block cobbleFence;
    public static final Block mossyCobbleFence;
    public static final Block smoothStoneFence;
    public static final Block brickFence;
    public static final Block stoneFence;
    public static final Block sandStoneFence;
    
    public static int COBBLESTONE_FENCE_ID = 234;
    public static int MOSSYCOBBLESTONE_FENCE_ID = 235;
    public static int SMOOTHSTONE_FENCE_ID = 236;
    public static int BRICK_FENCE_ID = 237;
    public static int STONE_FENCE_ID = 238;
    public static int SANDSTONE_FENCE_ID = 239; 
    
    private static int cobbleTexture = 16;
    private static int mossyTexture = 36;    
    private static int smoothTexture = 1;
    private static int brickTexture = 7;
    private static int stoneTexture = 54;
    private static int sandstoneTexture = 192;

    static
    {
    	cobbleFence = new BlockCobbleFence(COBBLESTONE_FENCE_ID, cobbleTexture)    					
    					.setBlockName("cobbleFence");
    	mossyCobbleFence = new BlockCobbleFence(MOSSYCOBBLESTONE_FENCE_ID, mossyTexture)    					
						.setBlockName("mossyCobbleFence");
    	smoothStoneFence = new BlockCobbleFence(SMOOTHSTONE_FENCE_ID, smoothTexture)    					
						.setBlockName("smoothStoneFence");
    	brickFence = new BlockCobbleFence(BRICK_FENCE_ID, brickTexture)    					
						.setBlockName("brickFence");
    	stoneFence = new BlockCobbleFence(STONE_FENCE_ID, stoneTexture)    					
						.setBlockName("stoneFence");
    	sandStoneFence = new BlockCobbleFence(SANDSTONE_FENCE_ID, sandstoneTexture)    					
						.setBlockName("mossyStoneFence"); 					
    }
    

    public mod_CobbleFence()
    {    		
    	ModLoader.RegisterBlock(cobbleFence);
        ModLoader.AddName(cobbleFence, "Cobblestone Wall");      
        
        ModLoader.RegisterBlock(mossyCobbleFence);
        ModLoader.AddName(mossyCobbleFence, "Mossy Cobblestone Wall");   
        
        ModLoader.RegisterBlock(smoothStoneFence);
        ModLoader.AddName(smoothStoneFence, "Smoothstone Wall");   
        
        ModLoader.RegisterBlock(brickFence);
        ModLoader.AddName(brickFence, "Brick Wall");   
        
        ModLoader.RegisterBlock(stoneFence);
        ModLoader.AddName(stoneFence, "Stone Wall");   
        
        ModLoader.RegisterBlock(sandStoneFence);
        ModLoader.AddName(sandStoneFence, "Sandstone Wall");   

        //Set up custom render ID         
        int temp = ModLoader.getUniqueBlockModelID(this, true);
        
		((BlockCobbleFence)cobbleFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(COBBLESTONE_FENCE_ID);
		
		 ((BlockCobbleFence)mossyCobbleFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(MOSSYCOBBLESTONE_FENCE_ID);
		 
		 ((BlockCobbleFence)smoothStoneFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(SMOOTHSTONE_FENCE_ID);
		 
		 ((BlockCobbleFence)brickFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(BRICK_FENCE_ID);
		 
		 ((BlockCobbleFence)stoneFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(STONE_FENCE_ID);
		 
		 ((BlockCobbleFence)sandStoneFence).setRenderType(temp);
		 ModLoader.RenderBlockIsItemFull3D(SANDSTONE_FENCE_ID);
		 
    		 	 
		// Setting up recipes
		ModLoader.AddRecipe(new ItemStack(cobbleFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.cobblestone
        });
		
		ModLoader.AddRecipe(new ItemStack(mossyCobbleFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.cobblestoneMossy
        });
		
		ModLoader.AddRecipe(new ItemStack(smoothStoneFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.stone
        });
		
		ModLoader.AddRecipe(new ItemStack(brickFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.brick
        });
		
		ModLoader.AddRecipe(new ItemStack(stoneFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.stoneBrick
        });
		
		ModLoader.AddRecipe(new ItemStack(sandStoneFence,6), new Object[]{
        	"###", "###", Character.valueOf('#'), Block.sandStone
        });   		
     
    }

    @Override
    public String Version()
    {
            return "1.8.1";
    }
    
    //Renders the look of the fence in Inventory
    public void RenderInvBlock(RenderBlocks renderblocks, Block block, int i, int j)
    {
    	Tessellator tessellator = Tessellator.instance;

    	//(0.0F, wallBottom, wallOffset, 1.0F, wallHeight, wallWidth);
        block.setBlockBounds(0.0F, 0.0F, 0.3F, 1.0F, 0.8F, 0.7F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, -1F, 0.0F);
        renderblocks.renderBottomFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(0));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        renderblocks.renderTopFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(1));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, -1F);
        renderblocks.renderEastFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(2));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 0.0F, 1.0F);
        renderblocks.renderWestFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(3));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(-1F, 0.0F, 0.0F);
        renderblocks.renderNorthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(4));
        tessellator.draw();
        tessellator.startDrawingQuads();
        tessellator.setNormal(1.0F, 0.0F, 0.0F);
        renderblocks.renderSouthFace(block, 0.0D, 0.0D, 0.0D, block.getBlockTextureFromSide(5));
        tessellator.draw();
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);

        block.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);   	
    }


    //Renders the look of the wall in the world
    public boolean RenderWorldBlock(RenderBlocks renderblocks, IBlockAccess iblockaccess, int i, int j, int k, Block block, int l)
    {
    	BlockCobbleFence blockCobbleFence = (BlockCobbleFence)block;
    	boolean flag = false;
    	
        //Wall Constants
        float wallOffset = 0.3F;
        float wallWidth = 0.7F;
        float wallBottom = 0.0F;
        float wallHeight = 0.8F;
    	
        float postOffset = 0.2F; //0.375F;
        float postWidth = 0.8F;//0.625F;
        float postHeight = 1.0F;  
        
               
        //NSWE Flags for rendering additional fence pieces
        boolean west = blockCobbleFence.isWallOrGateAt(iblockaccess, i - 1, j, k);
        boolean east = blockCobbleFence.isWallOrGateAt(iblockaccess, i + 1, j, k);
        boolean south = blockCobbleFence.isWallOrGateAt(iblockaccess, i, j, k - 1);
        boolean north = blockCobbleFence.isWallOrGateAt(iblockaccess, i, j, k + 1);
       
        /* Couldn't make this look pretty :(
        //Render Interaction with wooden objects
        boolean otherWest = blockCobbleFence.isWoodenFenceAt(iblockaccess, i - 1, j, k);
        boolean otherEast = blockCobbleFence.isWoodenFenceAt(iblockaccess, i + 1, j, k);
        boolean otherSouth = blockCobbleFence.isWoodenFenceAt(iblockaccess, i, j, k - 1);
        boolean otherNorth = blockCobbleFence.isWoodenFenceAt(iblockaccess, i, j, k + 1);

        */
       
        if(north && south && !(east || west)){
        	//Render full length wall North/South
        	blockCobbleFence.setBlockBounds(wallOffset, wallBottom, 0.0F, wallWidth, wallHeight, 1.0F);
            renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);            
        }else if(east && west && !(north || south)){
        	//Render Full length wall East/west
        	blockCobbleFence.setBlockBounds(0.0F, wallBottom, wallOffset, 1.0F, wallHeight, wallWidth);
            renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);            
        }else{
        	//Render Center Post          
            blockCobbleFence.setBlockBounds(postOffset, 0.0F, postOffset, postWidth, postHeight, postWidth);
            renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);
            
            //render West
            if(west){             
	            blockCobbleFence.setBlockBounds(0.0F, wallBottom, wallOffset, wallWidth, wallHeight, wallWidth);
	            renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);
            }            
            //Render East
            if(east){
                blockCobbleFence.setBlockBounds(wallOffset, wallBottom, wallOffset, 1.0F, wallHeight, wallWidth);
                renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);
            }            
            //Render North
            if(north)
            {
	            blockCobbleFence.setBlockBounds(wallOffset, wallBottom, wallOffset, wallWidth, wallHeight, 1.0F);
	            renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);
            }            
            //Render South
            if(south)
            {
            	blockCobbleFence.setBlockBounds(wallOffset, wallBottom, 0.0F, wallWidth, wallHeight, wallWidth);
            	renderblocks.renderStandardBlock(blockCobbleFence, i, j, k);
            }
        }

        blockCobbleFence.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        return true;
    }
}