package com.skt.educatonApi.beanscope.session;

public class Notes {

	/*
	      What is Session Scope?

			1> Scope: @Scope("session") or @Scope(value = WebApplicationContext.SCOPE_SESSION)

			2> Lifecycle: One bean instance per HTTP Session.

			3> Each user’s session gets its own bean instance.

			4> Bean is destroyed when the HTTP session ends (e.g., logout or session timeout).
			
			5> when we hit a request spring create sessionID which is basically created by tomcate
			   and store in JSESSIONID which is return back in response as we can see in postman 
			   cookie section and if we hit request from same tab postman sent back session to 
			   spring back postman tab preserve sessionid
			   
			6> using same session spring automatically check return back data which is assign back 
			   to this session
			   
			
			
			
	*/
}
