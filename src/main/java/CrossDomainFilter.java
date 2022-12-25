import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CrossDomainFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {}

    @Override
    public void destroy()
    {}

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Methods","GET,POST,OPTIONS");
        response.addHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept");

        if(request.getMethod().equals("OPTIONS"))
        {
            response.setStatus(HttpServletResponse.SC_OK);
            return;
        }
        chain.doFilter(request, servletResponse);
    }
}