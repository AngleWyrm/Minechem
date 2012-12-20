package ljdp.minechem.common;

import static ljdp.minechem.common.EnumElement.*;
import java.util.ArrayList;
import java.util.Random;

import net.minecraft.item.ItemStack;

public enum EnumMolecule {
	cellulose 				(0, "Cellulose", element(C, 6), element(H, 10), element(O, 5)),
	sucrose					(1, "Sucrose", element(C,12), element(H,22), element(O,11)),
	carbonDioxide   		(2, "Carbon Dioxide", element(C), element(O,2)),
	nitrogenDioxide 		(3, "Nitrogen Dioxide", element(N), element(O,2)),
	toluene					(4, "Toluene", element(C,7), element(H,8)),
	potassiumNitrate 		(5, "Potassium Nitrate", element(K), element(N), element(O,3)),
	tnt 					(6, "Trinitrotoluene", 
			element(C,6), 
			element(H,2), 
			molecule(nitrogenDioxide, 3), 
			molecule(toluene)
			),
	siliconDioxide			(7, "Silicon Dioxide", element(Si), element(O,2)),
	calcite					(8, "Calcite", element(Ca), element(C), element(O,3)),
	pyrite					(9, "Pyrite", element(Fe), element(S,2)),
	nepheline				(10, "Nepheline", element(Al), element(Si), element(O,4)),
	sulfate					(11, "Sulfate", element(S), element(O,4)),
	noselite				(12, "Noselite", element(Na,8), molecule(nepheline,6), molecule(sulfate)),
	sodalite				(13, "Sodalite", element(Na,8), molecule(nepheline,6), element(Cl,2)),
	nitrate					(14, "Nitrate", element(N), element(O,3)),
	carbonate				(15, "Carbonate", element(C), element(O,3)),
	cyanide					(16, "Cyanide", element(C), element(N)),
	phosphate				(17, "Phosphate", element(P), element(O,4)),
	acetate					(18, "Acetate", element(C,2), element(H,3), element(O,2)),
	chromate				(19, "Chromate", element(Cr), element(O,4)),
	hydroxide				(20, "Hydroxide", element(O), element(H)),
	ammonium				(21, "Ammonium", element(N), element(H,4)),
	hydronium				(22, "Hydronium", element(H,3), element(O)),
	peroxide				(23, "Peroxide", element(O,2)),
	calciumOxide			(24, "Calcium Oxide", element(Ca), element(O)),
	calciumCarbonate		(25, "Calcium Carbonate", element(Ca), molecule(carbonate)),
	magnesiumCarbonate		(26, "Magnesium Carbonate", element(Mg), molecule(carbonate)),
	lazurite				(27, "Lazurite", element(Na,8), molecule(nepheline), molecule(sulfate)),
	isoprene				(28, "Isoprene", element(C,5), element(H,8)),
	butene					(29, "Butene", element(C,4), element(H,8)),
	polyisobutylene			(30, "Polyisobutylene", molecule(butene,16), molecule(isoprene)),
	malicAcid				(31, "Malic Acid", element(C,4), element(H,6), element(O,5)),
	vinylChloride			(32, "Vinyl Chloride", element(C,2), element(H,3), element(Cl)),
	polyvinylChloride		(33, "Polyvinyl Chloride", molecule(vinylChloride,64)),
	methamphetamine 		(34, "Methamphetamine", element(C,10), element(H,15), element(N)),
	psilocybin				(35, "Psilocybin", element(C,12), element(H,17), element(N,2), element(O,4), element(P)),
	iron3oxide				(36, "Iron (III) Oxide", element(Fe,2), element(O,3)),
	strontiumNitrate		(37, "Strontium Nitrate", element(Sr), molecule(nitrate, 2)),
	magnetite				(38, "Magnetite", element(Fe,3), element(O,4)),
	magnesiumOxide			(39, "Magnesium Oxide", element(Mg), element(O)),
	cucurbitacin			(40, "Cucurbitacin", element(C,30), element(H,42), element(O,7)),
	asparticAcid			(41, "Aspartic Acid", element(C,4), element(H,7), element(N), element(O,4)),
	hydroxylapatite			(42, "Hydroxylapatite", element(Ca,5), molecule(phosphate,3), element(O), element(H)),
	alinine					(43, "Alinine", element(C,3), element(H,7), element(N), element(O,2)),
	glycine					(44, "Glycine", element(C,2), element(H,5), element(N), element(O,2)),
	serine					(45, "Serine",  element(C,3), element(H,7), molecule(nitrate)),
	mescaline				(46, "Mescaline", element(C,11), element(H,17), molecule(nitrate)),
	methyl					(47, "Methyl", element(C), element(H,3)),
	methylene				(48, "Methylene", element(C), element(H,2)),
	cyanoacrylate			(49, "Cyanoacrylate", molecule(methyl), molecule(methylene), element(C,3), element(N), element(H), element(O,2)),
	polycyanoacrylate		(50, "Poly-cyanoacrylate", molecule(cyanoacrylate, 3)),
	redPigment				(51, "Cobalt(II) nitrate", element(Co), molecule(nitrate,2)),
	orangePigment			(52, "Potassium Dichromate", element(K,2), element(Cr,2), element(O,7)),
	yellowPigment			(53, "Potassium Chromate", element(Cr), element(K,2), element(O,4)),
	limePigment				(54, "Nickel(II) Chloride", element(Ni), element(Cl,2)),
	lightbluePigment		(55, "Copper(II) Sulfate", element(Cu), molecule(sulfate)),
	purplePigment			(56, "Potassium Permanganate", element(K), element(Mn), element(O,4)),
	greenPigment			(57, "Zinc Green", element(Co), element(Zn), element(O,2)),
	blackPigment			(58, "Carbon Black", element(C), element(H,2), element(O)),
	whitePigment			(59, "Titanium Dioxide", element(Ti), element(O,2)),
	;
	
	
	public static EnumMolecule[] molecules = values();
	private final String descriptiveName;
	private final ArrayList components;
	private int id;
	public float red;
	public float green;
	public float blue;
	public float red2;
	public float green2;
	public float blue2;
	EnumMolecule(int id, String descriptiveName, Object...objects) {
		this.id = id;
		this.components = new ArrayList<ItemStack>();
		this.descriptiveName = descriptiveName;
		for(int i = 0; i < objects.length; i++) {
			this.components.add(objects[i]);
		}
		Random random = new Random(id);
		this.red = random.nextFloat();
		this.green = random.nextFloat();
		this.blue = random.nextFloat();
		this.red2 = random.nextFloat();
		this.green2 = random.nextFloat();
		this.blue2 = random.nextFloat();
	}
	
	public static EnumMolecule getById(int id) {
		for(EnumMolecule molecule : molecules) {
			if(molecule.id == id)
				return molecule;
		}
		return null;
	}
	
	public int id() {
		return this.id;
	}
	
	public String descriptiveName() {
		return this.descriptiveName;
	}
	
	public ArrayList<ItemStack> components() {
		return this.components;
	}
	
	private static ItemStack element(EnumElement element, int amount) {
		return new ItemStack(MinechemItems.element, amount, element.ordinal());
	}
	
	private static ItemStack element(EnumElement element) {
		return new ItemStack(MinechemItems.element, 1, element.ordinal());
	}
	
	private static ItemStack molecule(EnumMolecule molecule, int amount) {
		return new ItemStack(MinechemItems.molecule, amount, molecule.ordinal());
	}
	
	private static ItemStack molecule(EnumMolecule molecule) {
		return new ItemStack(MinechemItems.molecule, 1, molecule.ordinal());
	}
	
}
