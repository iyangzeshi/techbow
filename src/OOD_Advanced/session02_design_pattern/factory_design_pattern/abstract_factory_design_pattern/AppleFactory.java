package OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.phone.ApplePhone;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.phone.Phone;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.router.HuaweiRouter;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.router.Router;

//Project: techbow
//Package: OOD_Advanced.session02_design_pattern.factory_design_pattern
// .abstract_factory_design_pattern
//ClassName: ApplePhoneFactory
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-18 星期一 20:51
public class AppleFactory implements AbstractFactory {
    
    @Override
    public Phone makePhone() {
        return new ApplePhone();
    }
    
    @Override
    public Router makeRouter() {
        return new HuaweiRouter();
    }
    
}
