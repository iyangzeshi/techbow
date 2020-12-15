package OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern;

import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.phone.Phone;
import OOD_Advanced.session02_design_pattern.factory_design_pattern.abstract_factory_design_pattern.router.Router;

public interface AbstractFactory {
    Router makeRouter();
    Phone makePhone();
}
