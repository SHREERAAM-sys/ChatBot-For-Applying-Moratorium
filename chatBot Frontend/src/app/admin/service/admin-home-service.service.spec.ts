import { TestBed } from '@angular/core/testing';

import { AdminHomeServiceService } from './admin-home-service.service';

describe('AdminHomeServiceService', () => {
  let service: AdminHomeServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminHomeServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
