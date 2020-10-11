import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminOauthComponent } from './admin-oauth.component';

describe('AdminOauthComponent', () => {
  let component: AdminOauthComponent;
  let fixture: ComponentFixture<AdminOauthComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminOauthComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminOauthComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
