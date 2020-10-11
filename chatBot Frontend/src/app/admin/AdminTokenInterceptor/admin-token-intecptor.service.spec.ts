import { TestBed } from '@angular/core/testing';

import { AdminTokenIntecptorService } from './admin-token-intecptor.service';

describe('AdminTokenIntecptorService', () => {
  let service: AdminTokenIntecptorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AdminTokenIntecptorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
