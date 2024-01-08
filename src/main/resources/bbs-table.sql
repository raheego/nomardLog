DROP TABLE IF EXISTS bbs;
CREATE TABLE bbs (
    bbs_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    contents TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    modify_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    view_cnt INT DEFAULT 0,
    like_cnt INT DEFAULT 0,
    tag_id INT,
    is_deleted BOOLEAN DEFAULT 0,
    member_code INT
);

INSERT INTO bbs (title, contents, view_cnt, like_cnt, tag_id, member_code)
VALUES
  ('���� ���� �ı⢽', 'ù ��° �Խù��� �����Դϴ�.', 50, 10, 1, 101),
  ('������ ��� �Թ� ����', '�� ��° �Խù��� �����Դϴ�.', 30, 5, 2, 102),
  ('���� �ٱ� ����̺� ����', '�� ��° �Խù��� �����Դϴ�.', 20, 15, 1, 103),
  ('�λ� �ܿ� �ٴ�', '�� ��° �Խù��� �����Դϴ�.', 15, 7, 4, 107);

select * from bbs;

COMMIT;