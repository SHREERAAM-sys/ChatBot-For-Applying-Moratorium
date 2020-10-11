import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { HomeserviceService } from '../services/homeservice.service';
import { UserDetails } from '../admin/model/userDetails';
import { analyzeAndValidateNgModules } from '@angular/compiler';

@Component({
  selector: 'app-oauth',
  templateUrl: './oauth.component.html',
  styleUrls: ['./oauth.component.css']
})
export class OauthComponent implements OnInit {
  

  constructor(private router: Router,private acRoute: ActivatedRoute,private service: HomeserviceService) { }
  message: UserDetails; 
  ngOnInit(): void {

    const acessToken= this.acRoute.snapshot.queryParamMap.get('token');
   
    if(acessToken)
    {
      localStorage.setItem('token',acessToken);
      console.log('token set for google =====');
      console.log(localStorage.getItem('token'));
      
      this.service.getUserData().subscribe(data=>
        {
          this.message=data;
          console.log('got the in oauth login data=====\n');
          //console.log(this.message);
        
          // this.user.push(this.message);
          // console.log(this.user);
          if(this.message.registered==false && this.message.provider=="google")
          {
            this.router.navigate(['oauthRegistration']);
          }
          else{
            this.router.navigate(['home']);
          }
          //console.log(this.message);
        });
      
    }
  }

}
