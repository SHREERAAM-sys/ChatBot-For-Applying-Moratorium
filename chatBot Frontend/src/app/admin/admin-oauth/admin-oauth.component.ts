import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';


@Component({
  selector: 'app-admin-oauth',
  templateUrl: './admin-oauth.component.html',
  styleUrls: ['./admin-oauth.component.css']
})
export class AdminOauthComponent implements OnInit {

  constructor(private router: Router,private acRoute: ActivatedRoute) { }

  ngOnInit(): void {


    const acessToken= this.acRoute.snapshot.queryParamMap.get('token');

    if(acessToken)
    {
      localStorage.setItem('tokenAdmin',acessToken);
      console.log('token set for google =====');
      console.log(localStorage.getItem('tokenAdmin'));
      this.router.navigate(['admin/home']);
    }
  }


}
