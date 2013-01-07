package ljdp.minechem.computercraft.method;

import buildcraft.api.core.Position;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import dan200.computer.api.IComputerAccess;
import dan200.turtle.api.ITurtleAccess;
import ljdp.minechem.api.recipe.SynthesisRecipe;
import ljdp.minechem.common.tileentity.TileEntitySynthesis;
import ljdp.minechem.computercraft.ICCMethod;
import ljdp.minechem.computercraft.IMinechemPeripheral;

public class PlaceSynthesisRecipe implements ICCMethod {

	@Override
	public String getMethodName() {
		return "placeSynthesisRecipe";
	}

	@Override
	public Object[] call(IComputerAccess computer, ITurtleAccess turtle,
			IMinechemPeripheral minechemPeripheral, Object[] arguments)
			throws Exception 
	{
		boolean didPlace = false;
		TileEntitySynthesis synthesis = getSynthesisMachineInFrontOfTurtle(turtle);
		if(synthesis != null) {
			SynthesisRecipe recipe = minechemPeripheral.getSynthesisRecipe();
			synthesis.setRecipe(recipe);
			didPlace = true;
		}
		return new Object[]{ didPlace };
	}
	
	private TileEntitySynthesis getSynthesisMachineInFrontOfTurtle(ITurtleAccess turtle) {
		Vec3 vector = turtle.getPosition();
		ForgeDirection direction = ForgeDirection.getOrientation(turtle.getFacingDir());
		Position position = new Position(vector.xCoord, vector.yCoord, vector.zCoord, direction);
		position.moveForwards(1.0F);
		World world = turtle.getWorld();
		TileEntity tileEntity = world.getBlockTileEntity((int)position.x, (int)position.y, (int)position.z);
		if(tileEntity != null && tileEntity instanceof TileEntitySynthesis)
			return (TileEntitySynthesis) tileEntity;
		else
			return null;
	}

}
