package ljdp.minechem.common;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import ljdp.minechem.client.GuiDecomposer;
import ljdp.minechem.client.GuiMicroscope;
import ljdp.minechem.common.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import ljdp.minechem.common.MinechemItems;
import ljdp.minechem.common.network.PacketHandler;

@Mod(modid="minechem", name="MineChem", version="2.0.0a")
@NetworkMod(
		clientSideRequired=true, 
		serverSideRequired=false, 
		channels={PacketHandler.MINECHEM_PACKET_CHANNEL}, 
		packetHandler=PacketHandler.class
)
public class ModMinechem implements IGuiHandler {
	@Instance("minechem")
	public static ModMinechem instance;
	
	@SidedProxy(clientSide="ljdp.minechem.client.ClientProxy", serverSide="ljdp.minechem.common.CommonProxy")
	public static CommonProxy proxy;
	
	public static CreativeTabs minechemTab = new CreativeTabMinechem("mineChem");
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event) {
	}
	
	@Init
	public void init(FMLInitializationEvent event) {
		MinechemItems.registerItems();
		MinechemBlocks.registerBlocks();
		MinechemRecipes.getInstance();
		NetworkRegistry.instance().registerGuiHandler(this, this);
		proxy.registerRenderers();
		LanguageRegistry.instance().addStringLocalization("itemGroup.mineChem", "en_US", "MineChem");
	}
	
	@PostInit
	public void postInit(FMLPostInitializationEvent event) {
		
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityDecomposer)
			return new ContainerDecomposer(player.inventory, (TileEntityDecomposer)tileEntity);
		if(tileEntity instanceof TileEntityMicroscope)
			return new ContainerMicroscope(player.inventory, (TileEntityMicroscope)tileEntity);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
		if(tileEntity instanceof TileEntityDecomposer)
			return new GuiDecomposer(player.inventory, (TileEntityDecomposer)tileEntity);
		if(tileEntity instanceof TileEntityMicroscope)
			return new GuiMicroscope(player.inventory, (TileEntityMicroscope)tileEntity);
		return null;
	}
	
}
