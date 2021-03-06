package com.squaresuits.magicalpotionsandbrews;

import org.apache.logging.log4j.Logger;

import com.squaresuits.magicalpotionsandbrews.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MPBGlobal.MOD_ID, name = MPBGlobal.MOD_NAME, version = MPBGlobal.VERSION, dependencies = "after:tconstruct;required-after:basemetals;before:orespawn")
public class Main {
	
	public static Logger logger;
	

	@Instance(MPBGlobal.MOD_ID)
	public static Main instance;
	
	@SidedProxy(clientSide = MPBGlobal.NG_CLIENT_PROXY, serverSide = MPBGlobal.NG_COMMON_PROXY)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent preEvent){
		logger = preEvent.getModLog();
		Main.proxy.preInit(preEvent);
		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event){
		Main.proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent postEvent){
		Main.proxy.postInit(postEvent);
	}
}
