package hello.servlet.web.frontcontroller.v5.adapter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.Banner.Mode;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

public class ControllerV4HandlerAdapter
        implements MyHandlerAdapter {

    @Override
    public boolean supports(Object Handler) {
        return (Handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object Handler)
            throws IOException, ServletException {
        ControllerV4 controllerV4 = (ControllerV4) Handler;
        Map<String, Object> model = new HashMap<>();
        Map<String, String> paramMap = createParamMap(request);

        String viewName = controllerV4.process(paramMap, model);
        ModelView modelView = new ModelView(viewName);
        modelView.setModel(model);

        return modelView;
    }
    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
               .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
