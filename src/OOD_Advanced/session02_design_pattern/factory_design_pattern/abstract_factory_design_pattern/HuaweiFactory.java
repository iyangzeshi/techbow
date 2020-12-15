package OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.phone.HuaweiPhone;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.phone.Phone;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.router.HuaweiRouter;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.router.Router;

//Project: techbow
//Package: OOD_Advanced.session02_design_pattern.factory_design_pattern
// .abstract_factory_design_pattern
//ClassName: HuaweiPhoneFactory
//Author: Zeshi(Jesse) Yang
//Date: 2021-01-18 星期一 20:46
public class HuaweiFactory implements AbstractFactory {
    @Override
    public Phone makePhone() {
        return new HuaweiPhone();
    }
    
    @Override
    public Router makeRouter() {
        return new HuaweiRouter();
    }
    
}
