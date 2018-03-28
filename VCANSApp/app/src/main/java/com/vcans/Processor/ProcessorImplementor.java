package com.vcans.Processor;

import java.util.Vector;

import com.vcans.model.Send_Data;

public abstract class ProcessorImplementor {
	public abstract Vector<Vector<Send_Data> > GetSendDataV2(String[] extrData);
}
