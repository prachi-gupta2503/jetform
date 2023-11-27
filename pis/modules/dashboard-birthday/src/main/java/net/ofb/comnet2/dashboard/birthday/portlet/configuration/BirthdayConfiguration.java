package net.ofb.comnet2.dashboard.birthday.portlet.configuration;
import aQute.bnd.annotation.metatype.Meta;
@Meta.OCD(id = "net.ofb.comnet2.dashboard.birthday.portlet.configuration.BirthdayConfiguration")
public interface BirthdayConfiguration {


    @Meta.AD(
               required = false,deflt = "A"
    )
    public String selectGroup();
	
}
