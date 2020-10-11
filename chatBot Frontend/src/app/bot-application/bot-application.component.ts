import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HomeserviceService } from '../services/homeservice.service';
import { BotApplicationService } from '../services/bot-application.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-bot-application',
  templateUrl: './bot-application.component.html',
  styleUrls: ['./bot-application.component.css']
})
export class BotApplicationComponent implements OnInit {

  message:any;
  constructor(private http:HttpClient,private service:HomeserviceService,private serve:BotApplicationService,private router:Router )
   {

    console.log("START Constructor\n");
    

     

     this.serve.setUserResponse().subscribe((res:any)=>{});
     this.serve.setChatBotConvo().subscribe((res:any)=>{});
      
  }
    
  
  /*currentEmail=new BotRequest("");*/
  ngOnInit(): void {

  
    (function(d, m){
      var kommunicateSettings = 
          {"appId":"2ddfb96f0c47ca0fa9e4755d7a2874fd","popupWidget":true,"automaticChatOpenOnNavigation":true};
      var s = document.createElement("script"); s.type = "text/javascript"; s.async = true;
      s.src = "https://widget.kommunicate.io/v2/kommunicate.app";
      var h = document.getElementsByTagName("head")[0]; h.appendChild(s);
      (window as any).kommunicate = m; m._globals = kommunicateSettings;
      (window as any).Kommunicate.displayKommunicateWidget(false);
       
  })(document, (window as any).kommunicate || {});

  

}




public goToHome()
{
  //this.onSubmit();
  this.serve.setChatBotConvo().subscribe((res:any)=>{});
  this.router.navigate(['home']);

}
public logout()
  {
    localStorage.removeItem('token');
    //this.onSubmit();
    this.serve.setChatBotConvo();
    this.router.navigate(['login']);

  }

}
