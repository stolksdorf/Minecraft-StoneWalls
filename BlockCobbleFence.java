
package net.minecraft.src;


public class BlockCobbleFence extends Block
{
	int renderType = 0;
	public void setRenderType(int renderType)
	{
		this.renderType = renderType;
	}
	
    public BlockCobbleFence(int i, int textureID)
    {    	    	
    	super(i, textureID, Material.rock);    	
        // Need to create the item that will be dropped
        Item.itemsList[i] = new ItemBlock(i - 256);
        blocksList[i].initializeBlock();     
        
        this.setResistance(4.0F)
			.setHardness(1.0F)
			.setStepSound(Block.soundStoneFootstep)
			.setRequiresSelfNotify();

    }
    
    public boolean canPlaceBlockAt(World world, int i, int j, int k)
    {
        if(world.getBlockId(i, j - 1, k) == blockID)
        {
            return true;
        }
        if(!world.getBlockMaterial(i, j - 1, k).isSolid())
        {
            return false;
        } else
        {
            return super.canPlaceBlockAt(world, i, j, k);
        }
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        return AxisAlignedBB.getBoundingBoxFromPool(i, j, k, i + 1, (float)j + 1.5F, k + 1);
    }

    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    
    public int getRenderType()
    {
        return this.renderType;
    }

    public boolean isWallOrGateAt(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockId(i, j, k);
        return 
        	l == Block.fenceGate.blockID ||
        	l == mod_CobbleFence.cobbleFence.blockID ||         	
        	l == mod_CobbleFence.mossyCobbleFence.blockID ||
        	l == mod_CobbleFence.brickFence.blockID ||
        	l == mod_CobbleFence.sandStoneFence.blockID ||
        	l == mod_CobbleFence.smoothStoneFence.blockID ||
        	l == mod_CobbleFence.stoneFence.blockID ||        
        	l == mod_CobbleFence.sandStoneFence.blockID;    	
    }
    
    public boolean isWoodenFenceAt(IBlockAccess iblockaccess, int i, int j, int k)
    {
        int l = iblockaccess.getBlockId(i, j, k);
        return l == Block.fence.blockID || l == Block.fenceGate.blockID;
    }
    
}