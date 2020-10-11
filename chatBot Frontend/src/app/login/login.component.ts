import { Component, OnInit } from '@angular/core';

import { Router } from '@angular/router';
import { UserLoginService } from '../services/user-login.service';
import { UserLogin } from '../model/UserLogin';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})

export class LoginComponent implements OnInit {

  userLogin=new UserLogin("","");
  
  routerException:boolean = false;

  oauth_google="http://localhost:9090/oauth2/authorize/google?redirect_uri=http://localhost:4200/oauth2/redirect"

  message:any;
  constructor(private service:UserLoginService,private router: Router) {
    
    localStorage.removeItem('tokenAdmin');
    //localStorage.clear()
   }

  ngOnInit(): void {
  }

  
  public regirectGoogle()
  {
    window.location.href=this.oauth_google;
    //this.router.navigate(['home']);
  }
  public loginNow()
  {
    console.log("login now function started----");
    
    let resp=this.service.loginUser(this.userLogin);
    

    resp.subscribe((data:any)=>{

      //console.log(data.accessToken);

      if(data.accessToken)
      {
        localStorage.setItem('token',data.accessToken);
        console.log('the token is set sucess fully');
        //console.log(localStorage.getItem('token'));
        //if(this.service.welcome(localStorage.getItem('token')).subscribe(data=>console.log(data)))
        //{
          this.router.navigate(['home']);
        //}

      }
      (err)=>
      {
        console.log(err);
      }
                           //this.message=data.accessToken;
      //console.log(this.message);
    });
    //console.log(message.acessToken)
  }

}
