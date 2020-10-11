import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css']
})
export class AdminloginComponent implements OnInit {
  
  constructor(private service:AuthenticationService) {
    
    //this.service.logoutUser();
    localStorage.removeItem('token');
    //localStorage.clear();
   }
  oauth_google="http://localhost:9091/oauth2/authorize/google?redirect_uri=http://localhost:4200/adminOauth2/redirect"

  ngOnInit(): void {
  }

  public redirectGoogle()
  {
    window.location.href=this.oauth_google;
    //this.router.navigate(['home']);
  }

}
